/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Venda;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Janaína B da Silva
 */
public class VendasControle extends AbstractTableModel{
    List lista;
    
    public void setList(List lista){
        this.lista = lista;
    }
    
    public Venda getBean(int row){
        return (Venda) lista.get(row);
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
        Venda venda = (Venda) lista.get(rowIndex);
        if(columnIndex == 0){
            return venda.getIdvenda();
        }
        if(columnIndex == 1){
            return venda.getData();
        }
        if(columnIndex == 2){
            return venda.getCliente();
        }
        if(columnIndex == 3){
            return venda.getTotal();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        if(column == 0){
            return "id";
        }
        if(column == 1){
            return "data";
        }
        if(column == 2){
            return "cliente";
        }
        if(column == 3){
            return "total";
        }
        return "";
    }
}
