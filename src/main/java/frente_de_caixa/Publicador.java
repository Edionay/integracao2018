package frente_de_caixa;

import conexao_amqp.ConexaoAMQP;
import venda.Venda;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class Publicador {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException {

        Venda venda = new Venda("Sabonete",2.50,10);
        publicaMensagem(venda,"pedidos");

    }

    /**
     * Envia um objeto para ser publicado na fila
     * @param objeto
     * @param fila
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     * @throws URISyntaxException
     */
    public static void publicaMensagem(Object objeto, String fila) throws IOException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {

        ConexaoAMQP conexao = new ConexaoAMQP("amqp://guest:guest@localhost");

        //Serializa o objeto e publica na fila em byte[]
        conexao.enviarMensagem(Serializador.paraJSON(objeto),fila);
        }
}
