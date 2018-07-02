package sistema_principal;

import conexao_amqp.ConexaoAMQP;
import serializer.Serializer;
import venda.Venda;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class Consumidor {
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException,
            IOException, TimeoutException, InterruptedException, ClassNotFoundException {

        ConexaoAMQP conexao = new ConexaoAMQP("amqp://guest:guest@localhost", "pedidos");
        //Recebe o objeto e dá cast para Venda
        Venda venda = (Venda) consumir(conexao, "pedidos");
    }

    /**
     * Captura o byte[], transforma em Objeto e retorna o resultado
     * @param conexao
     * @param fila
     * @return
     * @throws IOException
     * @throws InterruptedException
     * @throws ClassNotFoundException
     */
    public static Object consumir(ConexaoAMQP conexao, String fila) throws IOException, InterruptedException, ClassNotFoundException {
        Serializer serializer = new Serializer();
        //Captura o byte[] e transforma em Objeto
        Object objeto = serializer.deserialize(conexao.consumirMensagem(fila));
        return objeto;
    }

}
