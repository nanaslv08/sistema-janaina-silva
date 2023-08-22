/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Usuario;
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
public class Usuario_DAO extends DAO_Abstract{
//public Usuario_DAO(){
//    
//}
    public Usuario_DAO() {

    }
    
    public Usuario logar (String apelido, String senha) {

        Usuario usuario = null;

        //         url = "jdbc:mysql://10.7.0.51:33062/db_janaina_silva";
//        user = "janaina_silva";
//        password = "janaina_silva";
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt = DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM usuario WHERE apelido = ? AND senha = ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setString(1, apelido);
            pstm.setString(2, senha);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setApelido(rs.getString("apelido"));
                usuario.setSenha(rs.getString("senha"));
            }

            rs.close();
            pstm.close();
            cnt.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }
    
    @Override
    public void insert(Object object) {
        Usuario usuario = (Usuario)object;
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
            String sql = "insert into usuario values(?, ?, ?, ?, ?, ?, ?, ?)";
            //stm.executeUpdate(sql);
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, usuario.getIdusuario());
            pstm.setString(2, usuario.getNome());
            pstm.setString(3, usuario.getApelido());
            pstm.setString(4, usuario.getCpf());
            pstm.setDate(5, (java.sql.Date) new Date(2021, 1, 1));
            pstm.setString(6, usuario.getSenha());
            pstm.setInt(7, usuario.getNivel());
            pstm.setString(8, usuario.getAtivo());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
         Usuario usuario = (Usuario)object;
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
      "UPDATE usuario SET nome = ?, apelido = ?, cpf = ?, data_nasc = ?, senha = ?, nivel = ?, ativo = ? WHERE idusuario = ?;");
//            String sql = "UPDATE usuario SET nome = ?, apelido = ?, cpf = ?, data_nasc = ?, senha = ?, nivel = ?, ativo = ? WHERE idusuario = ?;";
//            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getApelido());
            pstm.setString(3, usuario.getCpf());
            pstm.setDate(5, (java.sql.Date) new Date(2021, 1, 1));
            pstm.setString(5, usuario.getSenha());
            pstm.setInt(6, usuario.getNivel());
            pstm.setString(7, usuario.getAtivo());
            pstm.setInt(8, usuario.getIdusuario());
            pstm.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public void delete(Object object) {
            //String sql = "DELETE FROM usuario SET apelido WHERE idusuario=1;";
            //sem o set ele exclui tudo
        Usuario usuario = (Usuario)object;
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
            PreparedStatement pstm = cnt.prepareStatement("DELETE FROM usuario WHERE idusuario=?;");
            pstm.setInt(1, usuario.getIdusuario());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Object list(int id) {
        Usuario usuario = new Usuario();
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
            String sql = "SELECT * FROM usuario WHERE idusuario = ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()==true){
                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setApelido(rs.getString("apelido"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setData_nasc(rs.getDate("data_nasc"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setAtivo(rs.getString("ativo"));
                usuario.setNivel(rs.getInt("nivel"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return usuario;
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
            String sql = "SELECT * FROM usuario";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()==true){
                Usuario usuario = new Usuario();
                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setApelido(rs.getString("apelido"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setData_nasc(rs.getDate("data_nasc"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setAtivo(rs.getString("ativo"));
                usuario.setNivel(rs.getInt("nivel"));
                lista.add(usuario);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return lista;
    }
    
    public static void main(String[] args){
        Usuario usuario = new Usuario(); //bean;;
        usuario.setIdusuario(7);
        usuario.setNome("bia");
        usuario.setApelido("porquinha");
        usuario.setCpf("10918928345");
        //usuario.setData_nasc("");
        usuario.setSenha("porquinha");
        usuario.setNivel(2); 
        usuario.setAtivo("S");
        
        Usuario_DAO usuario_DAO = new Usuario_DAO();
        usuario_DAO.insert(usuario);
       System.out.println("deu certo");
        
//        Usuario usuario2 = new Usuario();
//        usuario2.setIdusuario(5);
//        usuario2.setNome("Savio Cantero");
//        usuario2.setApelido("sem apelido");
//        usuario2.setCpf("1234354567");
//        //usuario.setData_nasc("");
//        usuario2.setSenha("134523");
//        usuario2.setNivel(5); 
//        usuario2.setAtivo("N");
//        usuario_DAO.update(usuario2);
//         System.out.println("deu certo");

//        Usuario usuario3 = new Usuario();
//        usuario3.setIdusuario(7);
//        usuario_DAO.delete(usuario3);
//         System.out.println("deu certo");
    }
}
