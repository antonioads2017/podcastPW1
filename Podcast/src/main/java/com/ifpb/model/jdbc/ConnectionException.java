package com.ifpb.model.jdbc;

public class ConnectionException extends RuntimeException {

    public ConnectionException(String mensagem){
        super(mensagem);
    }
}
