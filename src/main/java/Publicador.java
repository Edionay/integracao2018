import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class Publicador {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException, InterruptedException, TimeoutException {

        ConexaoAMQP conexao = new ConexaoAMQP("amqp://guest:guest@localhost", "pedidos");
        String pedido = "teste";

        int contador = 0;

        while (contador < 5000) {
            String mensagem = "Mensagem número: " + contador;

            conexao.enviarMensagem(pedido);
            contador++;
            System.out.println("Mensagem publicada: " + mensagem);

            Thread.sleep(5000);
        }
    }
}
