/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Fornecedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Janaína B da Silva
 */
public class FornecedorControle extends AbstractTableModel{
    
    List lista;
    
    public void setList(List lista){
        this.lista = lista;
    }
    
    public Fornecedor getBean(int row){
        return (Fornecedor) lista.get(row);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Fornecedor fornecedor = (Fornecedor) lista.get(rowIndex);
        if(columnIndex == 0){
            return fornecedor.getIdfornecedor();
        }
        if(columnIndex == 1){
            return fornecedor.getNome();
        }
        if(columnIndex == 2){
            return fornecedor.getTelefone();
        }
        if(columnIndex == 3){
            return fornecedor.getCnpj();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        if(column == 0){
            return "id";
        }
        if(column == 1){
            return "nome";
        }
        if(column == 2){
            return "telefone";
        }
        if(column == 3){
            return "cnpj";
        }
        return "";
    }
}
