package com.curso.interceptors;


import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.logging.Logger;

@Logging
@Interceptor
public class LoggingInterceptor {
    @Inject
    private Logger logger;

    @AroundInvoke
    public Object logging(InvocationContext ic) throws Exception {
        logger.info("Entering method: " + ic.getMethod()
                .getName() + " in class: " + ic.getClass()
                .getDeclaringClass());
        Object result = ic.proceed();

        logger.info("Exiting method: " + ic.getMethod()
                .getName() + " in class: " + ic.getClass()
                .getDeclaringClass());


        return result;
    }
}
