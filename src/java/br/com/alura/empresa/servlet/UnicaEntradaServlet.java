/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.empresa.servlet;

import br.com.alura.empresa.acao.NovaEmpresa;
import br.com.alura.empresa.acao.AlterarEmpresa;
import br.com.alura.empresa.acao.MostrarEmpresa;
import br.com.alura.empresa.acao.Inicializador;
import br.com.alura.empresa.acao.ListaEmpresa;
import br.com.alura.empresa.acao.RemovaEmpresa;
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
        Inicializador acao = null;
       
        String page = null;

        if(paramAcao.equals("novaEmpresa")){
            acao = new NovaEmpresa();
        } else if (paramAcao.equals("listaEmpresas")) {
            acao = new ListaEmpresa();
        } else if (paramAcao.contains("removeEmpresa")) {
            acao = new RemovaEmpresa();
        } else if (paramAcao.contains("mostrarEmpresa")) {
            acao = new MostrarEmpresa();
        } else if (paramAcao.contains("alteraEmprsa")) {
            acao = new AlterarEmpresa();
        }
        
        acao.execute(request, response);
        
        String[] pagina = acao.getPage().split(":");
        if (pagina[0].equals("forward")) {   
        RequestDispatcher rd = request.getRequestDispatcher(pagina[1]);
        rd.forward(request, response);
        } else {
        response.sendRedirect(pagina[1]);
        }
        
    }

}
