package com.svillanueva.interceptors;


import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.sql.Connection;
import java.sql.SQLException;

@TransactionalJdbc
@Interceptor
public class TransactionalInterceptor {
    @Inject
    @MySqlConn
    private Connection conn;


    @AroundInvoke
    public Object transactional(InvocationContext invocationContext) throws SQLException {
        if (conn.getAutoCommit()) {
            conn.setAutoCommit(false);
        }
        Object resultado = null;
        try {
            resultado = invocationContext.proceed();
        } catch (Exception e) {
            conn.rollback();
            throw new RuntimeException(e);
        }
        conn.commit();
        return resultado;
    }
}
