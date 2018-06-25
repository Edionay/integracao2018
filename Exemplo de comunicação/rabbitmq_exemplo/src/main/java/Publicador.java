import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class Publicador {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException, InterruptedException, TimeoutException {
        ConnectionFactory fabricaDeConexao = new ConnectionFactory();
        fabricaDeConexao.setUri("amqp://guest:guest@localhost");
        fabricaDeConexao.setConnectionTimeout(300000);
        Connection connection = fabricaDeConexao.newConnection();
        Channel canal = connection.createChannel();

        canal.queueDeclare("my-queue", true, false, false, null);

        int contador = 0;

        while (contador < 5000) {
            String mensagem = "Message number " + contador;

            canal.basicPublish("", "my-queue", null, mensagem.getBytes());
            contador++;
            System.out.println("Published message: " + mensagem);

            Thread.sleep(5000);
        }
    }
}
