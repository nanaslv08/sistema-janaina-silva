/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Fornecedor;
import java.sql.Connection;
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
public class Fornecedor_DAO extends DAO_Abstract{

    
    @Override
    public void insert(Object object) {
        Fornecedor fornecedor = (Fornecedor)object;
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
            String sql = "insert into fornecedor values(?, ?, ?, ?, ?)";
            //stm.executeUpdate(sql);
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, fornecedor.getIdfornecedor());
            pstm.setString(2, fornecedor.getNome());
            pstm.setString(3, fornecedor.getTelefone());
            pstm.setString(4, fornecedor.getEmail());
            pstm.setString(5, fornecedor.getCnpj());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
         Fornecedor fornecedor = (Fornecedor)object;
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
      "UPDATE fornecedor SET nome = ?, telefone = ?, email = ?, cnpj = ? WHERE idfornecedor = ?;");
//            String sql = "UPDATE fornecedor SET nome = ?, apelido = ?, cpf = ?, data_nasc = ?, senha = ?, nivel = ?, ativo = ? WHERE idfornecedor = ?;";
//            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setString(1, fornecedor.getNome());
            pstm.setString(2, fornecedor.getTelefone());
            pstm.setString(3, fornecedor.getEmail());
            pstm.setString(4, fornecedor.getCnpj());
            pstm.setInt(5, fornecedor.getIdfornecedor());
            pstm.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public void delete(Object object) {
            //String sql = "DELETE FROM fornecedor SET apelido WHERE idfornecedor=1;";
            //sem o set ele exclui tudo
        Fornecedor fornecedor = (Fornecedor)object;
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
            PreparedStatement pstm = cnt.prepareStatement("DELETE FROM fornecedor WHERE idfornecedor=?;");
            pstm.setInt(1, fornecedor.getIdfornecedor());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Object list(int id) {
        Fornecedor fornecedor = new Fornecedor();
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
            String sql = "SELECT * FROM fornecedor WHERE idfornecedor = ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()==true){
                fornecedor.setIdfornecedor(rs.getInt("idfornecedor"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setCnpj(rs.getString("cnpj"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return fornecedor;    }

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
            String sql = "SELECT * FROM fornecedor";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()==true){
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdfornecedor(rs.getInt("idfornecedor"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                lista.add(fornecedor);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return lista;
    }
    
    public static void main(String[] args){
        Fornecedor fornecedor = new Fornecedor(); //bean;
        fornecedor.setIdfornecedor(1);
        fornecedor.setNome("nana");
        fornecedor.setTelefone("67992181853");
        fornecedor.setEmail("nainabs667@gmail.com");
        fornecedor.setCnpj("sla");

        Fornecedor_DAO fornecedor_DAO = new Fornecedor_DAO();
        fornecedor_DAO.insert(fornecedor);
       System.out.println("deu certo");
        
//        Fornecedor fornecedor2 = new Fornecedor();
//        fornecedor2.setIdfornecedor(1);
//        fornecedor2.setNome("bia");
//        fornecedor2.setTelefone("094747357");
//        fornecedor2.setEmail("nainansjn");
//        fornecedor2.setCnpj("porquinha");
//        fornecedor_DAO.update(fornecedor2);
//         System.out.println("deu certo");

//        Fornecedor fornecedor3 = new Fornecedor();
//        fornecedor3.setIdfornecedor(7);
//        fornecedor_DAO.delete(fornecedor3);
//         System.out.println("deu certo");
    }
}

