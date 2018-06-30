import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class ConexaoAMQP  {

    private ConnectionFactory fabricaDeConexao = new ConnectionFactory();
    private Connection conexao = fabricaDeConexao.newConnection();
    private Channel canal = conexao.createChannel();

    public ConexaoAMQP(String enderecoAMQP, String fila) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException {
        fabricaDeConexao.setUri(enderecoAMQP);
        fabricaDeConexao.setConnectionTimeout(10000);
        canal.queueDeclare(fila, true, false, false, null);
    }

    public void enviarMensagem(String mensagem) throws IOException {
        canal.basicPublish("", "pedidos", null, mensagem.getBytes());
    }

    public void consumirMensagem() throws IOException, InterruptedException {
        QueueingConsumer consumidor = new QueueingConsumer(canal);
        canal.basicConsume("pedidos", false, consumidor);

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

