package com.curso.filters;

import com.curso.services.ServiceJdbcException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/curso/*")
public class ConexionFilter implements Filter {
/*
    @Inject
    @MySqlConn
    private Connection conn;

 */

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        try {
//            Connection conn = this.conn;
//
//            if (conn.getAutoCommit()) {
//                conn.setAutoCommit(false);
//            }

        try {
//                request.setAttribute("conn", conn);
            chain.doFilter(request, response);
//                conn.commit();
        } catch (ServiceJdbcException e) {
//                conn.rollback();
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
//    } catch(
//    SQLException throwable)
//
//    {
//        throw new ServletException(throwable);
//    }
}
}
