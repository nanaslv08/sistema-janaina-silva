/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Janaína B da Silva
 */
public class ListaUsuarioB {
    public static void main(String[] args){
        List lista = new ArrayList();
        Usuario usuario = new Usuario();
        usuario.setIdusuario(1);
        usuario.setNome("Janaina");
        usuario.setApelido("nana");
        usuario.setCpf("04745597185");
        lista.add(usuario);
        lista.add(new Usuario(2, "joao", "jj"));
    }
    
}
