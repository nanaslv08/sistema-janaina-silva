/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Compra_Produto;
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
public class Compra_Produto_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        Compra_Produto compra_produto = (Compra_Produto)object;
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
            String sql = "insert into compra_produto values(?, ?, ?, ?, ?, ?, ?)";
            //stm.executeUpdate(sql);
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, compra_produto.getIdCompra_produto());
            pstm.setInt(2, compra_produto.getProduto());
            pstm.setInt(3, compra_produto.getCompra());
            pstm.setString(4, compra_produto.getQuantidade());
            pstm.setDouble(5, compra_produto.getV_unitario());
            pstm.setDouble(6, compra_produto.getTotal());
            pstm.setInt(7, compra_produto.getNum_compra());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Compra_Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compra_Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
         Compra_Produto compra_produto = (Compra_Produto)object;
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
      "UPDATE compra_produto SET produto = ?, compra = ?, quantidade = ?, v_unitario = ?, total = ?, num_compra = ? WHERE idcompra_produto = ?;");
//            String sql = "UPDATE compra_produto SET nome = ?, apelido = ?, cpf = ?, data_nasc = ?, senha = ?, nivel = ?, ativo = ? WHERE idcompra_produto = ?;";
//            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, compra_produto.getProduto());
            pstm.setInt(2, compra_produto.getCompra());
            pstm.setString(3, compra_produto.getQuantidade());
            pstm.setDouble(4, compra_produto.getV_unitario());
            pstm.setDouble(5, compra_produto.getTotal());
            pstm.setInt(6, compra_produto.getNum_compra());
            pstm.setInt(7, compra_produto.getIdCompra_produto());
            pstm.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Compra_Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compra_Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public void delete(Object object) {
            //String sql = "DELETE FROM compra_produto SET apelido WHERE idcompra_produto=1;";
            //sem o set ele exclui tudo
        Compra_Produto compra_produto = (Compra_Produto)object;
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
            PreparedStatement pstm = cnt.prepareStatement("DELETE FROM compra_produto WHERE idcompra_produto=?;");
            pstm.setInt(1, compra_produto.getIdCompra_produto());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Compra_Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compra_Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Object list(int id) {
        Compra_Produto compra_produto = new Compra_Produto();
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
            String sql = "SELECT * FROM compra_produto WHERE idcompra_produto = ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()==true){
                compra_produto.setIdCompra_produto(rs.getInt("idcompra_produto"));
                compra_produto.setProduto(rs.getInt("produto"));
                compra_produto.setCompra(rs.getInt("compra"));
                compra_produto.setQuantidade(rs.getString("quantidade"));
                compra_produto.setV_unitario(rs.getDouble("v_unitario"));
                compra_produto.setTotal(rs.getDouble("total"));
                compra_produto.setNum_compra(rs.getInt("num_compra"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Compra_Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compra_Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return compra_produto;
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
            String sql = "SELECT * FROM compra_produto";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()==true){
                Compra_Produto compra_produto = new Compra_Produto();
                compra_produto.setIdCompra_produto(rs.getInt("idcompra_produto"));
                compra_produto.setProduto(rs.getInt("produto"));
                compra_produto.setCompra(rs.getInt("compra"));
                compra_produto.setQuantidade(rs.getString("quantidade"));
                compra_produto.setV_unitario(rs.getDouble("v_unitario"));
                compra_produto.setTotal(rs.getDouble("total"));
                compra_produto.setNum_compra(rs.getInt("num_compra"));
                lista.add(compra_produto);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Compra_Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compra_Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return lista;
    }
    
    public static void main(String[] args){
        Compra_Produto compra_produto = new Compra_Produto(); //bean;
        compra_produto.setIdCompra_produto(7);
        compra_produto.setProduto(1);
        compra_produto.setCompra(1);
        compra_produto.setQuantidade("2");
        compra_produto.setV_unitario(4.50);
        compra_produto.setTotal(9.00); 
        compra_produto.setNum_compra(1);
         Compra_Produto_DAO compra_produto_DAO = new Compra_Produto_DAO();
        compra_produto_DAO.insert(compra_produto);
        System.out.println("deu certo");
        
//        Compra_produto compra_produto2 = new Compra_produto();
//        compra_produto2.setIdcompra_produto(7);
//        compra_produto2.setProduto(1);
//        compra_produto2.setCompra(1);
//        compra_produto2.setQuantidade("2");
//        compra_produto2.setV_unitario(4,50);
//        compra_produto2.setTotal(9,00); 
//        compra_produto2.setNum_compra("1");
//        compra_produto_DAO.update(compra_produto2);
//         System.out.println("deu certo");

//        Compra_Produto compra_produto3 = new Compra_Produto();
//        compra_produto3.setIdCompra_produto(7);
//        compra_produto_DAO.delete(compra_produto3);
//         System.out.println("deu certo");
    }
}

