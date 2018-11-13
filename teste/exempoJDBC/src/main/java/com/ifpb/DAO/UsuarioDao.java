package com.ifpb.DAO;

import com.ifpb.database.ConnectionFactory;
import com.ifpb.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {

    private static ConnectionFactory factory = new ConnectionFactory();

    public static boolean salvar(Usuario user) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement
                    ("INSERT INTO Usuario (cpf,nome,idade) VALUES(?,?,?)");

            statement.setString(1,user.getCPF());
            statement.setString(2,user.getNome());
            statement.setInt(3,user.getIdade());

            return statement.executeUpdate()>0;

        }
    }

    public static Usuario buscarPorCpf(String cpf) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT * FROM Usuario WHERE cpf = ?");

            statement.setString(1,cpf);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                Usuario user = new Usuario();
                user. setCPF(resultSet.getString(1));
                user.setNome(resultSet.getString(2));
                user.setIdade(resultSet.getInt(3));

                return user;
            }
            else{
                return null;
            }
        }
    }

    public static boolean remove(String cpf) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement
                    ("DELETE FROM Usuario  WHERE cpf=?");

            statement.setString(1,cpf);

            return statement.executeUpdate()>0;
        }
    }

    public static boolean update(Usuario user) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement
                    ("UPDATE Usuario SET nome=?,idade=? WHERE cpf=?");

            statement.setString(1,user.getNome());
            statement.setInt(2,user.getIdade());
            statement.setString(3,user.getCPF());

            return statement.executeUpdate()>0;
        }
    }

}
