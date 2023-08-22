/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Vendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Janaína B da Silva
 */
public class VendedorControle extends AbstractTableModel{
    List lista;
    
    public void setList(List lista){
        this.lista = lista;
    }
    
    public Vendedor getBean(int row){
        return (Vendedor) lista.get(row);
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
        Vendedor vendedor = (Vendedor) lista.get(rowIndex);
        if(columnIndex == 0){
            return vendedor.getIdvendedor();
        }
        if(columnIndex == 1){
            return vendedor.getNome();
        }
        if(columnIndex == 2){
            return vendedor.getCpf();
        }
        if(columnIndex == 3){
            return vendedor.getCelular();
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
            return "cpf";
        }
        if(column == 3){
            return "celular";
        }
        return "";
    }
}
