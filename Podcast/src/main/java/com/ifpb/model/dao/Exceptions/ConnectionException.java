package com.ifpb.model.dao.Exceptions;

public class ConnectionException extends RuntimeException {

    public ConnectionException(String mensagem){
        super(mensagem);
    }
}
