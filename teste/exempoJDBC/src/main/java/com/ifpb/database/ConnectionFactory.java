package com.ifpb.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/Exemplo1PW1";
        String usuario = "postgres";
        String senha = "28041998";

        return DriverManager.getConnection(url, usuario, senha);
    }

}
