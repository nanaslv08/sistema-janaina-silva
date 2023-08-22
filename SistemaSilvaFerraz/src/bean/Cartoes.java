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
public class Cartoes {
    private int idcartoes;
    private String banco;
    private String num_cartao;
    private String cod_seguranca;
    private String num_agencia;
    private String num_conta;
    private Date data_validade;
    private int cliente;
    
    
    public Cartoes(){
    }

    /**
     * @return the idcartoes
     */
    public int getIdcartoes() {
        return idcartoes;
    }

    /**
     * @param idcartoes the idcartoes to set
     */
    public void setIdcartoes(int idcartoes) {
        this.idcartoes = idcartoes;
    }

    /**
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the num_cartao
     */
    public String getNum_cartao() {
        return num_cartao;
    }

    /**
     * @param num_cartao the num_cartao to set
     */
    public void setNum_cartao(String num_cartao) {
        this.num_cartao = num_cartao;
    }

    /**
     * @return the cod_seguranca
     */
    public String getCod_seguranca() {
        return cod_seguranca;
    }

    /**
     * @param cod_seguranca the cod_seguranca to set
     */
    public void setCod_seguranca(String cod_seguranca) {
        this.cod_seguranca = cod_seguranca;
    }

    /**
     * @return the num_agencia
     */
    public String getNum_agencia() {
        return num_agencia;
    }

    /**
     * @param num_agencia the num_agencia to set
     */
    public void setNum_agencia(String num_agencia) {
        this.num_agencia = num_agencia;
    }

    /**
     * @return the num_conta
     */
    public String getNum_conta() {
        return num_conta;
    }

    /**
     * @param num_conta the num_conta to set
     */
    public void setNum_conta(String num_conta) {
        this.num_conta = num_conta;
    }

    /**
     * @return the data_validade
     */
    public Date getData_validade() {
        return data_validade;
    }

    /**
     * @param data_validade the data_validade to set
     */
    public void setData_validade(Date data_validade) {
        this.data_validade = data_validade;
    }

    /**
     * @return the id_cliente
     */
    public int getCliente() {
        return cliente;
    }

    /**
     * @param cliente the id_cliente to set
     */
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
    }
