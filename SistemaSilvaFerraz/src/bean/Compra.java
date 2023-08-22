/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author Janaina
 */
public class Compra {
    private int idcompra;
    private Date data;
    private int num_compra;
    private double total;
    private int fornecedor;
    private int usuario;
    
    public Compra(){
    }
//fornecedor int(11) 
//usuario int(11)

    /**
     * @return the idcompra
     */
    public int getIdcompra() {
        return idcompra;
    }

    /**
     * @param idcompra the idcompra to set
     */
    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
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
     * @return the fornecedor
     */
    public int getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the usuario
     */
    public int getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
}
