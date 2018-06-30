package sistema_principal;

import conexao_amqp.ConexaoAMQP;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class Consumidor {
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException, TimeoutException, InterruptedException {

        ConexaoAMQP conexao = new ConexaoAMQP("amqp://guest:guest@localhost", "pedidos");
        conexao.consumirMensagem();
    }
}
