import com.google.gson.Gson;
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

        canal.queueDeclare("lista", true, false, false, null);

        int contador = 0;

        while (contador < 5000) {
            String mensagem = "Mensagem número: " + contador;

            canal.basicPublish("", "lista", null, mensagem.getBytes());
            contador++;
            System.out.println("Mensagem publicada: " + mensagem);

            Thread.sleep(5000);
        }
    }
}
