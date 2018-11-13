package com.ifpb.view;

import com.ifpb.DAO.UsuarioDao;
import com.ifpb.model.Usuario;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

//        Usuario user = new Usuario("111.111.111-11","Mailson",18);
        try {
            System.out.println(UsuarioDao.salvar(new Usuario("122.221-22","Camila",20)));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
