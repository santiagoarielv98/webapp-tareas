package com.svillanueva.interceptors;

import com.svillanueva.services.ServiceJdbcException;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.sql.Connection;

@TransactionalJdbc
@Interceptor
public class TransactionalInterceptor {

    @Inject
    private Connection conn;


    @AroundInvoke
    public Object transactional(InvocationContext invocation) throws Exception {
        if (conn.getAutoCommit()) {
            conn.setAutoCommit(false);
        }
        try {
            Object resultado = invocation.proceed();
            conn.commit();
            return resultado;
        } catch (ServiceJdbcException e) {
            conn.rollback();
            throw e;
        }
    }
}
