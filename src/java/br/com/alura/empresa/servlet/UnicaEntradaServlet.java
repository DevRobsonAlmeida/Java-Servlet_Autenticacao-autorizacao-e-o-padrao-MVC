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

/**
 *
 * @author robson-pc
 */
public class UnicaEntradaServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String paramAcao = request.getParameter("acao");
        String nomeDaClasse = "br.com.alura.empresa.acao." + paramAcao;
        Class classe;
        Acao acao;
        String[] pagina = null;

        try {
            classe = Class.forName(nomeDaClasse);

            acao = (Acao) classe.newInstance();
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

//        if(paramAcao.equals("cadastrarEmpresa")){
//            acao = new CadastrarEmpresa();
//        } else if(paramAcao.equals("novaEmpresa")){
//            acao = new NovaEmpresa();
//        } else if (paramAcao.equals("listaEmpresas")) {
//            acao = new ListaEmpresa();
//        } else if (paramAcao.contains("removeEmpresa")) {
//            acao = new RemovaEmpresa();
//        } else if (paramAcao.contains("mostrarEmpresa")) {
//            acao = new MostrarEmpresa();
//        } else if (paramAcao.contains("alteraEmprsa")) {
//            acao = new AlterarEmpresa();
//        }  
    }

}
