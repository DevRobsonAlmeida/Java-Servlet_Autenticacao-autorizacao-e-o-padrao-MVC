/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.empresa.acao;

import br.com.alura.empresa.modelo.Banco;
import br.com.alura.empresa.modelo.Empresa;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author robson-pc
 */
public class MostrarEmpresa extends Acao {

    public MostrarEmpresa() {
        super("forward:formAlterarEmpresa.jsp");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();
        Empresa empresa = banco.consultarId(id);

        request.setAttribute("empresa", empresa);

//        RequestDispatcher rd = request.getRequestDispatcher("formAlterarEmpresa.jsp");
//        rd.forward(request, response);

    }

}
