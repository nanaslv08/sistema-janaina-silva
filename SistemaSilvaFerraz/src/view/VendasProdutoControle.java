/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Venda_Produto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Janaína B da Silva
 */
public class VendasProdutoControle extends AbstractTableModel{
    List lista;
    
    public void setList(List lista){
        this.lista = lista;
    }
    
    public Venda_Produto getBean(int row){
        return (Venda_Produto) lista.get(row);
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
        Venda_Produto vendas_produto = (Venda_Produto) lista.get(rowIndex);
        if(columnIndex == 0){
            return vendas_produto.getIdvenda_produto();
        }
        if(columnIndex == 1){
            return vendas_produto.getProduto();
        }
        if(columnIndex == 2){
            return vendas_produto.getQuantidade();
        }
        if(columnIndex == 3){
            return vendas_produto.getVenda();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        if(column == 0){
            return "id";
        }
        if(column == 1){
            return "produto";
        }
        if(column == 2){
            return "quantidade";
        }
        if(column == 3){
            return "venda";
        }
        return "";
    }
}
