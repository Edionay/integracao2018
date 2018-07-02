package conexao_amqp;

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

    /**
     *Contrutor da conexãoAMQP
     *
     * @param enderecoAMQP
     * @param fila
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     * @throws URISyntaxException
     * @throws IOException
     */
    public ConexaoAMQP(String enderecoAMQP, String fila) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException {
        fabricaDeConexao.setUri(enderecoAMQP);
        fabricaDeConexao.setConnectionTimeout(10000);
        canal.queueDeclare(fila, true, false, false, null);
    }

    /**
     * Envia a mensagem em byte[] para a fila
     * @param mensagem
     * @param fila
     * @throws IOException
     */
    public void enviarMensagem(byte[] mensagem, String fila) throws IOException {
        canal.basicPublish("", fila, null, mensagem);
    }

    /**
     * Consome a mensagem da fila e a retorna o byte[]
     * @param fila
     * @throws IOException
     * @throws InterruptedException
     */
    public byte[] consumirMensagem(String fila) throws IOException, InterruptedException {
        QueueingConsumer consumidor = new QueueingConsumer(canal);
        canal.basicConsume(fila, false, consumidor);

        QueueingConsumer.Delivery entrega = consumidor.nextDelivery();

        if (entrega != null) {
            try {
                byte[] mensagem = entrega.getBody();
//              String mensagem = new String(entrega.getBody(), StandardCharsets.UTF_8);
                canal.basicAck(entrega.getEnvelope().getDeliveryTag(), false);

                return mensagem;

            } catch (Exception e) {
                canal.basicAck(entrega.getEnvelope().getDeliveryTag(), true);
            }
        }
        return null;
    }
}

