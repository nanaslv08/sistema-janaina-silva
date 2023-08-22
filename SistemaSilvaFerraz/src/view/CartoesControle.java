/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import bean.Cartoes;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Janaína B da Silva
 */
public class CartoesControle extends AbstractTableModel{
    
    List lista;
    
    public void setList(List lista){
        this.lista = lista;
    }
    
    public Cartoes getBean(int row){
        return (Cartoes) lista.get(row);
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
        Cartoes cartoes = (Cartoes) lista.get(rowIndex);
        if(columnIndex == 0){
            return cartoes.getIdcartoes();
        }
        if(columnIndex == 1){
            return cartoes.getBanco();
        }
        if(columnIndex == 2){
            return cartoes.getNum_agencia();
        }
        if(columnIndex == 3){
            return cartoes.getNum_conta();
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
            return "apelido";
        }
        if(column == 3){
            return "cpf";
        }
        return "";
    }
}
