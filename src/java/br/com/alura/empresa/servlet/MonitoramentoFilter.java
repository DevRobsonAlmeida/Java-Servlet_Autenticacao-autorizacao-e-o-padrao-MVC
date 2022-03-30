/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.empresa.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Robson
 */
@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        long antes = System.currentTimeMillis();

        String acao = request.getParameter("acao");

        // Execução da ação
        chain.doFilter(request, response);

        long depois = System.currentTimeMillis();
        System.out.println("Tempo de execução da acao: " + acao + " - > " + (depois - antes));

    }

}
