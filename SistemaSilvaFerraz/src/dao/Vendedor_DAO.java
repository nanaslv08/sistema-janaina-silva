/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Vendedor;
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
public class Vendedor_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        Vendedor vendedor = (Vendedor)object;
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
            String sql = "insert into vendedor values(?, ?, ?, ?, ?, ?, ?, ?)";
            //stm.executeUpdate(sql);
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, vendedor.getIdvendedor());
            pstm.setString(2, vendedor.getNome());
            pstm.setString(3, vendedor.getCpf());
            pstm.setString(4, vendedor.getEmail()); 
            pstm.setString(5, vendedor.getCelular());
            pstm.setDate(6, (java.sql.Date) new Date(2021, 1, 1));
            pstm.setString(7, vendedor.getEstado());
            pstm.setString(8, vendedor.getGenero());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
         Vendedor vendedor = (Vendedor)object;
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
      "UPDATE vendedor SET nome = ?, cpf = ?, email = ?, celular = ?, data_nasc = ?, estado = ?, genero = ? WHERE idvendedor = ?;");
//            String sql = "UPDATE vendedor SET nome = ?, apelido = ?, cpf = ?, data_nasc = ?, senha = ?, nivel = ?, ativo = ? WHERE idvendedor = ?;";
//            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setString(1, vendedor.getNome());
            pstm.setString(2, vendedor.getCpf());
            pstm.setString(3, vendedor.getEmail()); 
            pstm.setString(4, vendedor.getCelular());
            pstm.setDate(5, (java.sql.Date) new Date(2021, 1, 1));
            pstm.setString(6, vendedor.getEstado());
            pstm.setString(7, vendedor.getGenero());
            pstm.setInt(8, vendedor.getIdvendedor());
            pstm.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public void delete(Object object) {
            //String sql = "DELETE FROM vendedor SET apelido WHERE idvendedor=1;";
            //sem o set ele exclui tudo
        Vendedor vendedor = (Vendedor)object;
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
            PreparedStatement pstm = cnt.prepareStatement("DELETE FROM vendedor WHERE idvendedor=?;");
            pstm.setInt(1, vendedor.getIdvendedor());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Object list(int id) {
        Vendedor vendedor = new Vendedor();
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
            String sql = "SELECT * FROM vendedor WHERE idvendedor = ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()==true){
                vendedor.setIdvendedor(rs.getInt("idvendedor"));
                vendedor.setNome(rs.getString("nome"));
                vendedor.setCpf(rs.getString("cpf"));
                vendedor.setEmail(rs.getString("email"));
                vendedor.setCelular(rs.getString("celular"));
                vendedor.setData_nasc(rs.getDate("data_nasc"));
                vendedor.setEstado(rs.getString("estado"));
                vendedor.setGenero(rs.getString("genero"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return vendedor;
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
            String sql = "SELECT * FROM vendedor";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()==true){
                Vendedor vendedor = new Vendedor();
                vendedor.setIdvendedor(rs.getInt("idvendedor"));
                vendedor.setNome(rs.getString("nome"));
                vendedor.setCpf(rs.getString("cpf"));
                vendedor.setEmail(rs.getString("email"));
                vendedor.setCelular(rs.getString("celular"));
                vendedor.setData_nasc(rs.getDate("data_nasc"));
                vendedor.setEstado(rs.getString("estado"));
                vendedor.setGenero(rs.getString("genero"));
                lista.add(vendedor);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return lista;
    }
    
    public static void main(String[] args){
        Vendedor vendedor = new Vendedor(); //bean;
        vendedor.setIdvendedor(1);
        vendedor.setNome("bia");
        vendedor.setCpf("10918928345");
        vendedor.setEmail("jedjennfkd");
        vendedor.setCelular("10918928345");
        //vendedor.setData_nasc("");
        vendedor.setEstado("MS");
        vendedor.setGenero("F"); 

        Vendedor_DAO vendedor_DAO = new Vendedor_DAO();
        vendedor_DAO.insert(vendedor);
       System.out.println("deu certo");
        
//        Vendedor vendedor2 = new Vendedor();
//        vendedor2.setIdvendedor(1);
//        vendedor2.setNome("bia");
//        vendedor2.setCpf("10918928345");
//        vendedor2.setEmail("jedjennfkd");
//        vendedor2.setCelular("10918928345");
//        //vendedor2.setData_nasc("");
//        vendedor2.setEstado("MS");
//        vendedor2.setGenero("F");
//        vendedor_DAO.update(vendedor2);
//         System.out.println("deu certo");

//        Vendedor vendedor3 = new Vendedor();
//        vendedor3.setIdvendedor(7);
//        vendedor_DAO.delete(vendedor3);
//         System.out.println("deu certo");
    }
}
