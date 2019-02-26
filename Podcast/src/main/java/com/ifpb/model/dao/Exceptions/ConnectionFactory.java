package com.ifpb.model.dao.Exceptions;

import com.ifpb.model.jdbc.ConnectionException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static String url;
    private static String usuario;
    private static String senha;
    private static String driver;
    private static ConnectionFactory instance = null;
    // A variável de instância vai fazer com que a fábrica gere apenas uma instância da conexão.

    public static ConnectionFactory getInstance(){
        if (instance == null) {
            synchronized (ConnectionFactory.class) {
                if (instance == null) {
                    instance = new ConnectionFactory();
                }
            }
        }
        return instance;
    }

    private static final Logger logger = Logger.getLogger(ConnectionFactory.class.getName());

    static {
        Properties properties = new Properties();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(inputStream);
            inputStream.close();
            url = properties.getProperty("database.url");
            usuario = properties.getProperty("database.user");
            senha = properties.getProperty("database.password");
            driver = properties.getProperty("database.driver");
        } catch (IOException e) {
            logger.severe("Falha ao carregar arquivo de configuração");
        }
    }

    public Connection getConnection() throws ConnectionException {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new ConnectionException("Driver não encontrado");
        } catch (SQLException e) {
            throw new ConnectionException("Falha ao conectar com o banco de dados");
        }
        return connection;
    }



}
