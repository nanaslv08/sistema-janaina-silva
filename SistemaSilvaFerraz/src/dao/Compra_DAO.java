/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Compra;
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
public class Compra_DAO extends DAO_Abstract {

    
    @Override
    public void insert(Object object) {
        Compra compra = (Compra)object;
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
            String sql = "insert into compra values(?, ?, ?, ?, ?, ?)";
            //stm.executeUpdate(sql);
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, compra.getIdcompra());
            pstm.setDate(2, (java.sql.Date) new Date(2001,1,1));
            pstm.setInt(3, compra.getNum_compra());
            pstm.setDouble(4, compra.getTotal());
            pstm.setInt(5, compra.getFornecedor());
            pstm.setInt(6, compra.getUsuario());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Compra_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compra_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Compra compra = (Compra)object;
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
      "UPDATE compra SET data = ?, num_compra = ?, total = ?, fornecedor = ?, usuario = ? WHERE idcompra = ?;");
//            String sql = "UPDATE compra SET nome = ?, apelido = ?, cpf = ?, data_nasc = ?, senha = ?, nivel = ?, ativo = ? WHERE idcompra = ?;";
//            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setDate(1, (java.sql.Date) new Date(2001,1,1));
            pstm.setInt(2, compra.getNum_compra());
            pstm.setDouble(3, compra.getTotal());
            pstm.setInt(4, compra.getFornecedor());
            pstm.setInt(5, compra.getUsuario());
            pstm.setInt(6, compra.getIdcompra());
            pstm.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Compra_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compra_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public void delete(Object object) {
            //String sql = "DELETE FROM compra SET apelido WHERE idcompra=1;";
            //sem o set ele exclui tudo
        Compra compra = (Compra)object;
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
            PreparedStatement pstm = cnt.prepareStatement("DELETE FROM compra WHERE idcompra=?;");
            pstm.setInt(1, compra.getIdcompra());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Compra_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compra_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Object list(int id) {
        Compra compra = new Compra();
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
            String sql = "SELECT * FROM compra WHERE idcompra = ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()==true){
                compra.setIdcompra(rs.getInt("idcompra"));
                compra.setData(rs.getDate("data"));
                compra.setNum_compra(rs.getInt("num_compra"));
                compra.setTotal(rs.getDouble("total"));
                compra.setFornecedor(rs.getInt("fornecedor"));
                compra.setUsuario(rs.getInt("usuario"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Compra_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compra_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return compra; 
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
            String sql = "SELECT * FROM compra";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()==true){
                Compra compra = new Compra();
                compra.setIdcompra(rs.getInt("idcompra"));
                compra.setData(rs.getDate("data"));
                compra.setNum_compra(rs.getInt("num_compra"));
                compra.setTotal(rs.getDouble("total"));
                compra.setFornecedor(rs.getInt("fornecedor"));
                compra.setUsuario(rs.getInt("usuario"));
                lista.add(compra);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Compra_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compra_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return lista;
    }
    
    public static void main(String[] args){
        Compra compra = new Compra(); //bean;
        compra.setIdcompra(1);
        //compra.setData_nasc("");
        compra.setNum_compra(3);
        compra.setTotal(13.50); 
        compra.setFornecedor(1);
        compra.setUsuario(1);
         Compra_DAO compra_DAO = new Compra_DAO();
       compra_DAO.insert(compra);
       System.out.println("deu certo");
        
//        Compra compra2 = new Compra();
//        compra2.setIdcompra(1);
//        //compra2.setData_nasc("");
//        compra2.setNum_compra(3);
//        compra2.setTotal(13,90);
//        compra2.setFornecedor(1);
//        compra2.setcompra(1);
//        compra_DAO.update(compra2);
//         System.out.println("deu certo");

//        Compra compra3 = new Compra();
//        compra3.setIdcompra(1);
//        compra_DAO.delete(compra3);
//         System.out.println("deu certo");
    }
}

