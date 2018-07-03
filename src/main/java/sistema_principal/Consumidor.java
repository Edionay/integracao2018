package sistema_principal;

import conexao_amqp.ConexaoAMQP;
import venda.Venda;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class Consumidor {
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException,
            IOException, InterruptedException, ClassNotFoundException {

        ConexaoAMQP conexao = new ConexaoAMQP("amqp://guest:guest@localhost");

        // Consome uma mensagem a partir da fila "pedidos", previamente definida no canal
        Venda venda = consumirVenda(conexao, "pedidos");
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
    public static Venda consumirVenda(ConexaoAMQP conexao, String fila) throws IOException, InterruptedException {
        //Captura o byte[] e transforma em Objeto
        return Desserializador.jsonParaVenda(conexao.consumirMensagem(fila));
    }

}
