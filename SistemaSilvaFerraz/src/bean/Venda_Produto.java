/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Janaina
 */
public class Venda_Produto {    
    private int idvenda_produto;
    private int venda;
    private int produto;
    private String quantidade;
    private double v_unitario;
    
    public Venda_Produto(){
    
}

    /**
     * @return the idvenda_produto
     */
    public int getIdvenda_produto() {
        return idvenda_produto;
    }

    /**
     * @param idvenda_produto the idvenda_produto to set
     */
    public void setIdvenda_produto(int idvenda_produto) {
        this.idvenda_produto = idvenda_produto;
    }

    /**
     * @return the venda
     */
    public int getVenda() {
        return venda;
    }

    /**
     * @param venda the venda to set
     */
    public void setVenda(int venda) {
        this.venda = venda;
    }

    /**
     * @return the produto
     */
    public int getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(int produto) {
        this.produto = produto;
    }

    /**
     * @return the quantidade
     */
    public String getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the v_unitario
     */
    public double getV_unitario() {
        return v_unitario;
    }

    /**
     * @param v_unitario the v_unitario to set
     */
    public void setV_unitario(double v_unitario) {
        this.v_unitario = v_unitario;
    }
    
}


