/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Cartoes;
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
public class Cartoes_DAO extends DAO_Abstract {
    
    public void conexão(){
        
    }

    @Override
    public void insert(Object object) {
        Cartoes cartoes = (Cartoes)object;
        String url, user, password;
//         url = "jdbc:mysql://10.7.0.51:33062/db_janaina_silva";
//        user = "janaina_silva";
//        password = "janaina_silva";
        url = "jdbc:mysql://127.0.0.1:3306/aula_marcos";
        user = "root";
        password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            Statement stm;
            stm = cnt.createStatement();
            String sql = "insert into cartoes values (?, ?, ?, ?, ?, ?, ?, ?)";
            //stm.executeUpdate(sql);
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, cartoes.getIdcartoes());
            pstm.setString(2, cartoes.getBanco());
            pstm.setString(3, cartoes.getNum_cartao());
            pstm.setString(4, cartoes.getCod_seguranca());
            pstm.setString(5, cartoes.getNum_agencia());
            pstm.setString(6, cartoes.getNum_conta());
            pstm.setDate(7, (java.sql.Date) new Date(2021, 1, 1));
            pstm.setInt(8, cartoes.getCliente());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cartoes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cartoes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Cartoes cartoes = (Cartoes)object;
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
      "UPDATE cartoes SET banco = ?, num_conta = ?, cod_seguranca = ?, num_agencia = ?, num_conta = ?, data_validade= ? WHERE idcartoes = ?;");
//            String sql = "UPDATE cartoes SET nome = ?, apelido = ?, cpf = ?, data_nasc = ?, senha = ?, nivel = ?, ativo = ? WHERE idcartoes = ?;";
//            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, cartoes.getIdcartoes());
            pstm.setString(2, cartoes.getBanco());
            pstm.setString(3, cartoes.getNum_cartao());
            pstm.setString(4, cartoes.getCod_seguranca());
            pstm.setString(5, cartoes.getNum_agencia());
            pstm.setString(6, cartoes.getNum_conta());
            pstm.setDate(7, (java.sql.Date) new Date(2021, 1, 1));
            pstm.setInt(8, cartoes.getCliente());
            pstm.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cartoes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cartoes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public void delete(Object object) {
            //String sql = "DELETE FROM cartoes SET apelido WHERE idcartoes=1;";
            //sem o set ele exclui tudo
       Cartoes cartoes = (Cartoes)object;
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
            PreparedStatement pstm = cnt.prepareStatement("DELETE FROM cartoes WHERE idcartoes=?;");
            pstm.setInt(1, cartoes.getIdcartoes());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cartoes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cartoes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Object list(int id) { 
        Cartoes cartoes = new Cartoes();
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
            String sql = "SELECT * FROM cartoes WHERE idcartoes = ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()==true){
                cartoes.setIdcartoes(rs.getInt("idcartoes"));
                cartoes.setBanco(rs.getString("banco"));
                cartoes.setNum_cartao(rs.getString("num_cartao"));
                cartoes.setCod_seguranca(rs.getString("cod_seguranca"));
                cartoes.setNum_agencia(rs.getString("num_agencia"));
                cartoes.setNum_conta(rs.getString("num_conta"));
                cartoes.setData_validade(rs.getDate("data_validade"));
                cartoes.setCliente(rs.getInt("cliente"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cartoes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cartoes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return cartoes;
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
            String sql = "SELECT * FROM cartoes";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()==true){
                Cartoes cartoes = new Cartoes();
                cartoes.setIdcartoes(rs.getInt("idcartoes"));
                cartoes.setBanco(rs.getString("banco"));
                cartoes.setNum_cartao(rs.getString("num_cartao"));
                cartoes.setCod_seguranca(rs.getString("cod_seguranca"));
                cartoes.setNum_agencia(rs.getString("num_agencia"));
                cartoes.setNum_conta(rs.getString("num_conta"));
                cartoes.setData_validade(rs.getDate("data_validade"));
                cartoes.setCliente(rs.getInt("cliente"));
                lista.add(cartoes);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cartoes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cartoes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return lista;
    }
    
    public static void main(String[] args){
        Cartoes cartoes = new Cartoes();
        cartoes.setIdcartoes(3);
        cartoes.setBanco("BB");
        cartoes.setNum_cartao("1278");
        cartoes.setCod_seguranca("123");
        cartoes.setNum_agencia("12345");
        cartoes.setNum_conta("4567");
        cartoes.setCliente(7);
        
        Cartoes_DAO cartoes_DAO = new Cartoes_DAO();
        cartoes_DAO.insert(cartoes);
        System.out.println("deu certo");
        
//        Cartoes cartoes2 = new Cartoes();;
//        cartoes2.setIdcartoes(7);
//        cartoes2.setBanco("BB");
//        cartoes2.setNum_cartao(1278);
//        cartoes2.setCod_seguranca("123");
//        cartoes2.setNum_agencia("12345");
//        cartoes2.setNum_conta("4567");
//        cartoes_DAO.update(cartoes2);
//         System.out.println("deu certo");

//        Cartoes cartoes3 = new Cartoes();
//        cartoes3.setIdcartoes(7);
//        cartoes_DAO.delete(cartoes3);
//         System.out.println("deu certo");
    }
}
