/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.empresa.acao;

import br.com.alura.empresa.modelo.Banco;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author robson-pc
 */
public class RemoveEmpresa extends Acao{

    public RemoveEmpresa() {
        super("redirect:entrada?acao=ListaEmpresas");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();
        banco.removeEmpresa(id);

//        response.sendRedirect("entrada?acao=listaEmpresas");
    }

}
