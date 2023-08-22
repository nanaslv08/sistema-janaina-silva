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
public class Fornecedor {
    private int idfornecedor;
    private String nome;
    private String telefone;
    private String email;
    private String cnpj;

    
    public Fornecedor(){
        
    }
    /**
     * @return the idfornecedor
     */
    public int getIdfornecedor() {
        return idfornecedor;
    }

    /**
     * @param idfornecedor the idfornecedor to set
     */
    public void setIdfornecedor(int idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public String toString(){
        return getNome() + "-" + getCnpj();
    }
}
