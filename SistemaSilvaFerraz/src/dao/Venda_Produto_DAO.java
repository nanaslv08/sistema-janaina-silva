/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Venda_Produto;
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
public class Venda_Produto_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        Venda_Produto venda_produto = (Venda_Produto)object;
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
            String sql = "insert into venda_produto values(?, ?, ?, ?, ?)";
            //stm.executeUpdate(sql);
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, venda_produto.getIdvenda_produto());
            pstm.setInt(2, venda_produto.getVenda());
            pstm.setInt(3, venda_produto.getProduto());
            pstm.setString(4, venda_produto.getQuantidade());
            pstm.setDouble(5, venda_produto.getV_unitario());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Venda_Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Venda_Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
         Venda_Produto venda_produto = (Venda_Produto)object;
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
      "UPDATE venda_produto SET venda = ?, produto = ?, quantidade = ?, v_unitario = ? WHERE idvenda_produto = ?;");
//            String sql = "UPDATE venda_produto SET nome = ?, apelido = ?, cpf = ?, data_nasc = ?, senha = ?, nivel = ?, ativo = ? WHERE idvenda_produto = ?;";
//            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, venda_produto.getVenda());
            pstm.setInt(2, venda_produto.getProduto());
            pstm.setString(3, venda_produto.getQuantidade());
            pstm.setDouble(4, venda_produto.getV_unitario());
            pstm.setInt(5, venda_produto.getIdvenda_produto());
            pstm.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Venda_Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Venda_Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public void delete(Object object) {
            //String sql = "DELETE FROM venda_produto SET apelido WHERE idvenda_produto=1;";
            //sem o set ele exclui tudo
        Venda_Produto venda_produto = (Venda_Produto)object;
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
            PreparedStatement pstm = cnt.prepareStatement("DELETE FROM venda_produto WHERE idvenda_produto=?;");
            pstm.setInt(1, venda_produto.getIdvenda_produto());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Venda_Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Venda_Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Object list(int id) {
        Venda_Produto venda_produto = new Venda_Produto();
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
            String sql = "SELECT * FROM venda_produto WHERE idvenda_produto = ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()==true){
                venda_produto.setIdvenda_produto(rs.getInt("idvenda_produto"));
                venda_produto.setProduto(rs.getInt("produto"));
                venda_produto.setQuantidade(rs.getString("quantidade"));
                venda_produto.setV_unitario(rs.getDouble("v_unitario"));
                venda_produto.setVenda(rs.getInt("venda"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return venda_produto;    
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
            String sql = "SELECT * FROM venda_produto";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()==true){
                Venda_Produto venda_produto = new Venda_Produto();
                venda_produto.setIdvenda_produto(rs.getInt("idvenda_produto"));
                venda_produto.setProduto(rs.getInt("produto"));
                venda_produto.setQuantidade(rs.getString("quantidade"));
                venda_produto.setV_unitario(rs.getDouble("v_unitario"));
                venda_produto.setVenda(rs.getInt("venda"));
                lista.add(venda_produto);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return lista;
    }
    
    public static void main(String[] args){
        Venda_Produto venda_produto = new Venda_Produto(); //bean;
        venda_produto.setIdvenda_produto(7);
        venda_produto.setVenda(1);
        venda_produto.setProduto(1);
        venda_produto.setQuantidade("5");
        venda_produto.setV_unitario(2.50);
        Venda_Produto_DAO venda_produto_DAO = new Venda_Produto_DAO();
        venda_produto_DAO.insert(venda_produto);
       System.out.println("deu certo");
        
//        Venda_Produto venda_produto2 = new Venda_Produto();
//        venda_produto2.setIdvenda_produto(7);
//        venda_produto2.setVenda(1);
//        venda_produto2.setProduto(1);
//        venda_produto2.setQuantidade("5");
//        venda_produto2.setV_unitario(2,50);
//        venda_produto_DAO.update(venda_produto2);
//         System.out.println("deu certo");

//        Venda_Produto venda_produto3 = new Venda_Produto();
//        venda_produto3.setIdvenda_produto(7);
//        venda_produto_DAO.delete(venda_produto3);
//         System.out.println("deu certo");
    }
}

