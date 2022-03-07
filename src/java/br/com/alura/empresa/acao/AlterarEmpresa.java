/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.empresa.acao;

import br.com.alura.empresa.acao.Inicializador;
import br.com.alura.empresa.modelo.Banco;
import br.com.alura.empresa.modelo.Empresa;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author robson-pc
 */
public class AlterarEmpresa extends Inicializador {

    public AlterarEmpresa() {
        super("redirect:entrada?acao=listaEmpresas");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Empresa empresa = new Empresa();

            empresa.setId(Integer.valueOf(request.getParameter("id")));
            Banco banco = new Banco();

            empresa = banco.consultarId(empresa.getId());
            empresa.setNome(request.getParameter("nome"));
            empresa.setDataAbertura(sdf.parse(request.getParameter("data")));

//            response.sendRedirect("");

        } catch (ParseException ex) {
            Logger.getLogger(AlterarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
