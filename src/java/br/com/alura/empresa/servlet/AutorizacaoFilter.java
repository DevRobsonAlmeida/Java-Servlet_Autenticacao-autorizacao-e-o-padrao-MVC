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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Robson
 */
@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

    public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) ServletRequest;
        HttpServletResponse response = (HttpServletResponse) ServletResponse;
        

        String paramAcao = request.getParameter("acao");

        HttpSession session = request.getSession();
        boolean usuarioNaoLogado = (session.getAttribute("usuarioLogado") == null);
        boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));

        if (usuarioNaoLogado && acaoProtegida) {
            response.sendRedirect("entrada?acao=LoginForm");
            return;
        }

        chain.doFilter(request, response);

    }

}
