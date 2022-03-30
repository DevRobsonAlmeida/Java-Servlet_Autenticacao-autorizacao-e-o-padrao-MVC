/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.empresa.servlet;

import br.com.alura.empresa.acao.Acao;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Robson
 */
public class ControladorFilter implements Filter {

    public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) ServletRequest;
        HttpServletResponse response = (HttpServletResponse) ServletResponse;

        String paramAcao = request.getParameter("acao");

        String nomeDaClasse = "br.com.alura.empresa.acao." + paramAcao;
        String[] pagina = null;

        try {
            Acao acao = (Acao) Class.forName(nomeDaClasse).newInstance();
            acao.execute(request, response);
            pagina = acao.getPage().split(":");

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            throw new ServletException(ex);
        }

        String caminhoWeb = "WEB-INF/view/";
        if (pagina[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher(caminhoWeb.concat(pagina[1]));
            rd.forward(request, response);
        } else {
            response.sendRedirect(pagina[1]);
        }

    }

}
