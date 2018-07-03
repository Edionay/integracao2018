package sistema_principal;

import org.junit.Assert;
import org.junit.Test;
import venda.Venda;

import static org.junit.Assert.assertEquals;

public class DesserializadorTest {

    @Test
    public void jsonParaVenda() {
        Venda venda = new Venda("Sabonete",2.50,10);

        String json = "{\"produto\":\"Sabonete\",\"valor\":2.5,\"quantidade\":10 }";
        Assert.assertEquals(venda.getProduto(), Desserializador.jsonParaVenda(json).getProduto());
        Assert.assertEquals(venda.getQuantidade(), Desserializador.jsonParaVenda(json).getQuantidade());
        Assert.assertEquals(venda.getClass(), Desserializador.jsonParaVenda(json).getClass());
    }
}