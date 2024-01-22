package com.curso.filters;

import com.curso.services.ServiceJdbcException;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/curso/*")
public class ConexionFilter implements Filter {

    @Inject
    @Named("conn")
    private Connection conn;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try (Connection conn = this.conn) {

            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }

            try {
//                request.setAttribute("conn", conn);
                chain.doFilter(request, response);
                conn.commit();
            } catch (SQLException | ServiceJdbcException e) {
                conn.rollback();
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } catch (SQLException throwable) {
            throw new ServletException(throwable);
        }
    }
}
