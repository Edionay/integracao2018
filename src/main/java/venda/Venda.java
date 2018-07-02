package venda;

import java.io.Serializable;

public class Venda implements Serializable {

    private String produto;
    private double valor;
    private int quantidade;

    /**
     * Construtor da classe Venda
     * @param produto
     * @param valor
     * @param quantidade
     */
    public Venda(String produto, double valor, int quantidade) {
        this.setProduto(produto);
        this.setValor(valor);
        this.setQuantidade(quantidade);
    }

    public Byte toByte(){
        return this.toByte();
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Venda
     * Produto: + Value
     * Preço: R$ + Value
     * Quantidade: + Value
     *
     * @return
     */
    public String toString(){
    return  "/n Venda:/n" +
            "Produto: " + this.getProduto() + "/n" +
            "Preço: R$" + Double.toString(this.getValor()) + "/n" +
            "Quantidade: " + Integer.toString(this.getQuantidade());
    }
}
