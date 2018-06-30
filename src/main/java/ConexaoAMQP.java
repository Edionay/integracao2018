import com.rabbitmq.client.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class Consumidor {
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException, TimeoutException, InterruptedException {
        ConnectionFactory fabricaDeConexao = new ConnectionFactory();
        fabricaDeConexao.setUri("amqp://guest:guest@localhost");
        fabricaDeConexao.setConnectionTimeout(300000);
        Connection connection = fabricaDeConexao.newConnection();
        Channel canal = connection.createChannel();

        canal.queueDeclare("lista", true, false, false, null);

        QueueingConsumer consumidor = new QueueingConsumer(canal);
        canal.basicConsume("lista", false, consumidor);

        while (true) {
            QueueingConsumer.Delivery entrega = consumidor.nextDelivery();

            if (entrega != null) {
                try {
                    String mensagem = new String(entrega.getBody(), StandardCharsets.UTF_8);
                    System.out.println("Mensagem consumida: " +mensagem);
                    canal.basicAck(entrega.getEnvelope().getDeliveryTag(), false);
                } catch (Exception e) {
                    canal.basicAck(entrega.getEnvelope().getDeliveryTag(), true);

                }
            }
        }


    }
}
