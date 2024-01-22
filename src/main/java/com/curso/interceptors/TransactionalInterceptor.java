package com.curso.interceptors;

import com.curso.configs.MySqlConn;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.sql.Connection;
import java.util.logging.Logger;

@TransactionalJdbc
@Interceptor
public class TransactionalInterceptor {


    @Inject
    @MySqlConn
    private Connection conn;

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object transactional(InvocationContext ic) throws Exception {
        logger.info("Starting transaction");
        if (conn.getAutoCommit()) {
            conn.setAutoCommit(false);
        }
        try {
            Object result = ic.proceed();
            conn.commit();
            return result;
        } catch (Exception e) {
            conn.rollback();
            throw e;
        }
    }
}
