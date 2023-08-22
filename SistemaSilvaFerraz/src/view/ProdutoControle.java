/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Produto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Janaína B da Silva
 */
public class ProdutoControle extends AbstractTableModel{
    
    List lista;
    
    public void setList(List lista){
        this.lista = lista;
    }
    
    public Produto getBean(int row){
        return (Produto) lista.get(row);
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
        Produto produto = (Produto) lista.get(rowIndex);
        if(columnIndex == 0){
            return produto.getIdproduto();
        }
        if(columnIndex == 1){
            return produto.getNome();
        }
        if(columnIndex == 2){
            return produto.getValor();
        }
        if(columnIndex == 3){
            return produto.getCategoria();
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
            return "valor";
        }
        if(column == 3){
            return "categoria";
        }
        return "";
    }
}
