package com.ifpb.model.dao.Factory;

public class DAOFactory {

    public enum FactoryType { JDBC, FILE }

    public static DAOAbstractFactory createFactory(FactoryType type) {
        switch(type) {
            case JDBC:
                return new DAOFactoryJDBC();
            case FILE:
                throw new UnsupportedOperationException("Não implementado ainda");
        }
        return null;
    }
}
