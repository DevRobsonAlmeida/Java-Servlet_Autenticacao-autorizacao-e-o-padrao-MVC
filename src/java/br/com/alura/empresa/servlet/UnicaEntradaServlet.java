/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.empresa.servlet;

import br.com.alura.empresa.acao.Acao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author robson-pc
 */
public class UnicaEntradaServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String paramAcao = request.getParameter("acao");

//        HttpSession session = request.getSession();
//        boolean usuarioNaoLogado = (session.getAttribute("usuarioLogado") == null);
//        boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//
//        if (usuarioNaoLogado && acaoProtegida) {
//            response.sendRedirect("entrada?acao=LoginForm");
//            return;
//        }

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
