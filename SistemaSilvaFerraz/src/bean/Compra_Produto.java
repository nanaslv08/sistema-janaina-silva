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
public class Compra_Produto {
    private int idcompra_produto;
    private int produto;
    private int compra;
    private String quantidade;
    private double v_unitario;
    private double total;
    private int num_compra;
    
    public Compra_Produto(){
    }

    /**
     * @return the idcompra_produto
     */
    public int getIdCompra_produto() {
        return idcompra_produto;
    }

    /**
     * @param idcompra_produto the compra_produto to set
     */
    public void setIdCompra_produto(int idcompra_produto) {
        this.idcompra_produto = idcompra_produto;
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
     * @return the compra
     */
    public int getCompra() {
        return compra;
    }

    /**
     * @param compra the compra to set
     */
    public void setCompra(int compra) {
        this.compra = compra;
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

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the num_compra
     */
    public int getNum_compra() {
        return num_compra;
    }

    /**
     * @param num_compra the num_compra to set
     */
    public void setNum_compra(int num_compra) {
        this.num_compra = num_compra;
    }
}
