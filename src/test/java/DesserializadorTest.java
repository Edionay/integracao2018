import org.junit.Test;
import venda.Venda;

import static org.junit.Assert.*;
import static sistema_principal.Desserializador.jsonParaVenda;

public class DesserializadorTest {

    @Test
    public void testJsonParaVenda() {

        Venda venda = new Venda("Sabonete",2.50,10);

        String json = "{\"produto\":\"Sabonete\",\"valor\":2.5,\"quantidade\":10 }";
        assertEquals(venda.getProduto(), jsonParaVenda(json).getProduto());
        assertEquals(venda.getQuantidade(), jsonParaVenda(json).getQuantidade());
        assertEquals(venda.getClass(), jsonParaVenda(json).getClass());
    }
}