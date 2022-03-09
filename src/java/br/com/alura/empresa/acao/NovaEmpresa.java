/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.empresa.acao;

import br.com.alura.empresa.modelo.Banco;
import br.com.alura.empresa.modelo.Empresa;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author robson-pc
 */
public class NovaEmpresa extends Acao {

    public NovaEmpresa() {
        super("redirect:entrada?acao=ListaEmpresas");
    }
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        Empresa empresa = new Empresa();
        Date dataAbertura = null;

        String nomeEmpresa = request.getParameter("nome");
        String paramDataAbertura = request.getParameter("data");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = (paramDataAbertura == "" ? new Date() : sdf.parse(paramDataAbertura));

            empresa.setNome(nomeEmpresa);
            empresa.setDataAbertura(dataAbertura);
        } catch (ParseException ex) {
            throw new ServletException(ex);
        }

        Banco banco = new Banco();
        banco.adiciona(empresa);


        // Chamar JSP
//        request.setAttribute("nomeEmpresa", empresa.getNome());
//        request.setAttribute("dataAbertura", empresa.getDataAbertura());
//        RequestDispatcher rd = request.getRequestDispatcher("entrada?acao=listaEmpresas");
//        rd.forward(request, response);

        //Redireciona
//        response.sendRedirect("entrada?acao=listaEmpresas");

//    return ;

    }

}
