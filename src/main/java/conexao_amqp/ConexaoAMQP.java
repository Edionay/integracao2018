package conexao_amqp;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class ConexaoAMQP  {

    private final ConnectionFactory fabricaDeConexao = new ConnectionFactory();
    private final Connection conexao = fabricaDeConexao.newConnection();
    private final Channel canal = conexao.createChannel();

    /**
     *Contrutor da conexãoAMQP
     *
     * @param enderecoAMQP
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     * @throws URISyntaxException
     * @throws IOException
     */
    public ConexaoAMQP(String enderecoAMQP) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException {
        fabricaDeConexao.setUri(enderecoAMQP);
        fabricaDeConexao.setConnectionTimeout(10000);
    }

    /**
     * Envia a mensagem em byte[] para a fila
     * @param mensagem
     * @param fila
     * @throws IOException
     */
    public void enviarMensagem(String mensagem, String fila) throws IOException {
        System.out.println(mensagem);
        canal.basicPublish("", fila, null, mensagem.getBytes());
    }

    /**
     * Consome a mensagem da fila e a retorna o byte[]
     * @param fila
     * @throws IOException
     * @throws InterruptedException
     */
    public String consumirMensagem(String fila) throws IOException, InterruptedException {
        QueueingConsumer consumidor = new QueueingConsumer(canal);
        canal.basicConsume(fila, false, consumidor);

        QueueingConsumer.Delivery entrega = consumidor.nextDelivery();

        if (entrega != null) {
            try {
                byte[] mensagem = entrega.getBody();
                canal.basicAck(entrega.getEnvelope().getDeliveryTag(), false);

                return new String(mensagem, "UTF-8");

            } catch (Exception e) {
                canal.basicAck(entrega.getEnvelope().getDeliveryTag(), true);
            }
        }
        return null;
    }

}

