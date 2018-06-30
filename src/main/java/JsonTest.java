import com.google.gson.Gson;

public class JsonTest {

    public static void main(String[] args) {

        Pedido pedido1 = new Pedido();
        pedido1.setItens("Camaro Amarelo");
        pedido1.setTitulo("Pedido atrasado");

        Pedido pedido2 = new Pedido();
        pedido1.setItens("Camaro Azul");
        pedido1.setTitulo("Pedido em dia");

        Pedido[] pedidos = {};

        pedidos[1] = pedido2;


        Gson json = new Gson();
        String resposta = json.toJson(pedidos);

        System.out.println(resposta);
    }

}
