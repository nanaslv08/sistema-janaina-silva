/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Janaina
 */
public class Venda_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        Venda venda = (Venda)object;
        String url, user, password;
//         url = "jdbc:mysql://10.7.0.51:33062/db_janaina_silva";
//        user = "janaina_silva";
//        password = "janaina_silva";
        url = "jdbc:mysql://127.0.0.1:3306/test";
        user = "root";
        password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            Statement stm;
            stm = cnt.createStatement();
            String sql = "insert into venda values(?, ?, ?, ?, ?)";
            //stm.executeUpdate(sql);
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, venda.getIdvenda());
            pstm.setDate(2, (java.sql.Date) new Date(2021, 1, 1));
            pstm.setInt(3, venda.getCliente());
            pstm.setInt(4, venda.getVendedor());
            pstm.setDouble(5, venda.getTotal());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
         Venda venda = (Venda)object;
        String url, user, password;
//         url = "jdbc:mysql://10.7.0.51:33062/db_janaina_silva";
//        user = "janaina_silva";
//        password = "janaina_silva";
        url = "jdbc:mysql://127.0.0.1:3306/test";
        user = "root";
        password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            Statement stm;
            stm = cnt.createStatement();
            PreparedStatement pstm = cnt.prepareStatement(
      "UPDATE venda SET data = ?, cliente = ?, vendedor = ?, total = ? WHERE idvenda = ?;");
//            String sql = "UPDATE venda SET nome = ?, apelido = ?, cpf = ?, data_nasc = ?, senha = ?, nivel = ?, ativo = ? WHERE idvenda = ?;";
//            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setDate(1, (java.sql.Date) new Date(2021, 1, 1));
            pstm.setInt(2, venda.getCliente());
            pstm.setInt(3, venda.getVendedor());
            pstm.setDouble(4, venda.getTotal());
            pstm.setInt(5, venda.getIdvenda());
            pstm.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public void delete(Object object) {
            //String sql = "DELETE FROM venda SET apelido WHERE idvenda=1;";
            //sem o set ele exclui tudo
        Venda venda = (Venda)object;
        String url, user, password;
//         url = "jdbc:mysql://10.7.0.51:33062/db_janaina_silva";
//        user = "janaina_silva";
//        password = "janaina_silva";
        url = "jdbc:mysql://127.0.0.1:3306/test";
        user = "root";
        password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            Statement stm;
            stm = cnt.createStatement();
            PreparedStatement pstm = cnt.prepareStatement("DELETE FROM venda WHERE idvenda=?;");
            pstm.setInt(1, venda.getIdvenda());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Object list(int id) {
        Venda venda = new Venda();
        String url, user, password;
//         url = "jdbc:mysql://10.7.0.51:33062/db_janaina_silva";
//        user = "janaina_silva";
//        password = "janaina_silva";
        url = "jdbc:mysql://127.0.0.1:3306/test";
        user = "root";
        password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM venda WHERE idvenda = ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()==true){
                venda.setIdvenda(rs.getInt("idvenda"));
                venda.setData(rs.getDate("data"));
                venda.setCliente(rs.getInt("cliente"));
                venda.setVendedor(rs.getInt("vendedor"));
                venda.setTotal(rs.getDouble("total"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return venda;
    }

    @Override
    public List listAll() {
        String url, user, password;
//         url = "jdbc:mysql://10.7.0.51:33062/db_janaina_silva";
//        user = "janaina_silva";
//        password = "janaina_silva";
        url = "jdbc:mysql://127.0.0.1:3306/test";
        user = "root";
        password = "";
         List lista = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM venda";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()==true){
                Venda venda = new Venda();
                venda.setIdvenda(rs.getInt("idvenda"));
                venda.setData(rs.getDate("data"));
                venda.setCliente(rs.getInt("cliente"));
                venda.setVendedor(rs.getInt("vendedor"));
                venda.setTotal(rs.getDouble("total"));
                lista.add(venda);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return lista;    
    }
    
    public static void main(String[] args){
        Venda venda = new Venda(); //bean;
        venda.setIdvenda(1);
        //venda.setData("");
        venda.setCliente(1);
        venda.setVendedor(1); 
        venda.setTotal(9.00);

        Venda_DAO venda_DAO = new Venda_DAO();
        venda_DAO.insert(venda);
       System.out.println("deu certo");
        
//        Venda venda2 = new Venda();
//        venda2.setIdvenda(1);
//        //venda2.setData("");
//        venda2.setCliente(1);
//        venda2.setVendedor(1); 
//        venda2.setTotal(9.00);
//        venda_DAO.update(venda2);
//         System.out.println("deu certo");

//        Venda venda3 = new Venda();
//        venda3.setIdvenda(7);
//        venda_DAO.delete(venda3);
//         System.out.println("deu certo");
    }
}

