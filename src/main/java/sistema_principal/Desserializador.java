package sistema_principal;

import com.google.gson.Gson;
import venda.Venda;

public class Desserializador {
    /**
     * Serializa um JSON para um objeto Venda
     * @param mensagem
     * @return Objeto Venda
     */
    public static Venda jsonParaVenda(String mensagem) {

        Gson json = new Gson();

        return json.fromJson(mensagem, Venda.class);
    }
}
