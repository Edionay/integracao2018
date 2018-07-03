package venda;

import org.junit.Assert;
import org.junit.Test;
import sistema_principal.Desserializador;

import static org.junit.Assert.*;

public class VendaTest {

    Venda venda = new Venda("Sabonete",2.50,10);


    @Test
    public void getProduto() {
        Assert.assertEquals(venda.getProduto(), "Sabonete");
    }

    @Test
    public void setProduto() {
    }

    @Test
    public void getValor() {
        Assert.assertEquals(venda.getValor(), 2.5f, 0);

    }

    @Test
    public void setValor() {
    }

    @Test
    public void getQuantidade() {
        Assert.assertEquals(venda.getQuantidade(), 10);

    }

    @Test
    public void setQuantidade() {
    }

}