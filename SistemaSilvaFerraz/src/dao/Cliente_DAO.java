/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Cliente;
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
public class Cliente_DAO extends DAO_Abstract{

    @Override
    public void insert(Object object) {
        Cliente cliente = (Cliente)object;
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
            String sql = "insert into cliente values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            //stm.executeUpdate(sql);
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, cliente.getIdcliente());
            pstm.setString(2, cliente.getNome());
            pstm.setString(3, cliente.getCpf());
            pstm.setString(4, cliente.getRg());
            pstm.setDate(5, (java.sql.Date) new Date(2021, 1, 1));
            pstm.setString(6, cliente.getCelular());
            pstm.setString(7, cliente.getGenero());
            pstm.setString(8, cliente.getEmail());
            pstm.setString(9, cliente.getNaturalidade());
            pstm.setString(10, cliente.getRua());
            pstm.setString(11, cliente.getBairro());
            pstm.setString(12, cliente.getNumcasa());
            pstm.setString(13, cliente.getCidade());
            pstm.setString(14, cliente.getEstado());
            pstm.setString(15, cliente.getCep());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
         Cliente cliente = (Cliente)object;
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
      "UPDATE cliente SET nome = ?, cpf = ?, rg = ?, data_nasc = ?, celular = ?, genero = ?, email = ?, naturalidade = ?, rua = ?, bairro = ?, numcasa = ?, cidade = ?, estado = ?, cep = ? WHERE idcliente = ?;");
//            String sql = "UPDATE cliente SET nome = ?, cpf = ?, rg = ?, data_nasc = ?, celular = ?, genero = ?, email = ?, naturalidade = ?, rua = ?, bairro = ?, numcasa = ?, cidade = ?, estado = ?, cep = ? WHERE idcliente = ?;";
//            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpf());
            pstm.setString(3, cliente.getRg());
            pstm.setDate(4, (java.sql.Date) new Date(2021, 1, 1));
            pstm.setString(5, cliente.getCelular());
            pstm.setString(6, cliente.getGenero());
            pstm.setString(7, cliente.getEmail());
            pstm.setString(8, cliente.getNaturalidade());
            pstm.setString(9, cliente.getRua());
            pstm.setString(10, cliente.getBairro());
            pstm.setString(11, cliente.getNumcasa());
            pstm.setString(12, cliente.getCidade());
            pstm.setString(13, cliente.getEstado());
            pstm.setString(14, cliente.getCep());
            pstm.setInt(15, cliente.getIdcliente());
            pstm.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public void delete(Object object) {
            //String sql = "DELETE FROM cliente SET apelido WHERE idcliente=1;";
            //sem o set ele exclui tudo
        Cliente cliente = (Cliente)object;
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
            PreparedStatement pstm = cnt.prepareStatement("DELETE FROM cliente WHERE idcliente = ?;");
            pstm.setInt(1, cliente.getIdcliente());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Object list(int id) {
        Cliente cliente = new Cliente();
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
            String sql = "SELECT * FROM cliente WHERE idcliente = ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()==true){
                cliente.setIdcliente(rs.getInt("idcliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setData_nasc(rs.getDate("data_nasc"));
                cliente.setGenero(rs.getString("genero"));
                cliente.setEmail(rs.getString("email"));
                cliente.setNaturalidade(rs.getString("naturalidade"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setCep(rs.getString("cep"));
                cliente.setRua(rs.getString("rua"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setNumcasa(rs.getString("numcasa"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return cliente;    }

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
            String sql = "SELECT * FROM cliente";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()==true){
                Cliente cliente = new Cliente();
                cliente.setIdcliente(rs.getInt("idcliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setData_nasc(rs.getDate("data_nasc"));
                cliente.setGenero(rs.getString("genero"));
                cliente.setEmail(rs.getString("email"));
                cliente.setNaturalidade(rs.getString("naturalidade"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setCep(rs.getString("cep"));
                cliente.setRua(rs.getString("rua"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setNumcasa(rs.getString("numcasa"));
                lista.add(cliente);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return lista;    
    }
    
    public static void main(String[] args){
        Cliente cliente = new Cliente(); //bean;
        cliente.setIdcliente(1);
        cliente.setNome("nana");
        cliente.setCpf("189467902");
        cliente.setRg("4559765");
        //cliente.setData_nasc("");
        cliente.setCelular("92181853");
        cliente.setGenero("F"); 
        cliente.setEmail("nainabs667");
        cliente.setNaturalidade("brasileira");
        cliente.setRua("Rua monte castelo");
        cliente.setBairro("Nossa Senhora do Amparo");
        cliente.setNumcasa("185");
        cliente.setCidade("Ponta Porã");
        cliente.setEstado("MS");
        cliente.setCep("79904-290");
        Cliente_DAO cliente_DAO = new Cliente_DAO();
        cliente_DAO.insert(cliente);
       System.out.println("deu certo");
        
//        Cliente cliente2 = new Cliente();
//        cliente2.setIdcliente(7);
//        cliente2.setNome("bia");
//        cliente2.setCpf("123456789");
//        cliente2.setRg("1091892");
//        //cliente2.setData_nasc("");
//        cliente2.setCelular("+5567992181853");
//        cliente2.setGenero(2); 
//        cliente2.setEmail("dualservapp@gmail.com");
//        cliente2.setNaturalidade("brasileira");
//        cliente2.setRua("Rua monte castelo");
//        cliente2.setBairro("Marambaia");
//        cliente2.setNumcasa("204");
//        cliente2.setCidade("Ponta Porã");
//        cliente2.setEstad("MS");
//        cliente2.setCep("7902-490");
//        cliente_DAO.update(cliente2);
//        System.out.println("deu certo");

//        Cliente cliente3 = new Cliente();
//        cliente3.setIdcliente(7);
//        cliente_DAO.delete(cliente3);
//         System.out.println("deu certo");
    }
}

