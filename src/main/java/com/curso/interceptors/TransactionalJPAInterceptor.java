package com.curso.interceptors;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.persistence.EntityManager;

import java.util.logging.Logger;

@TransactionalJpa
@Interceptor
public class TransactionalJPAInterceptor {


    @Inject
    private EntityManager em;

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object transactional(InvocationContext ic) throws Exception {
        logger.info("Starting transaction");
        try {
            em.getTransaction().begin();
            Object result = ic.proceed();
            em.getTransaction().commit();
            return result;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
