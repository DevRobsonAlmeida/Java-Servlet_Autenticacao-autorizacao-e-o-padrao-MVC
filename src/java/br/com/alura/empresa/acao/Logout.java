/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.empresa.acao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Robson
 */
public class Logout extends Acao{

    @Override
    public String page() {
        return "redirect:entrada?acao=LoginForm";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //session.removeAttribute("usuarioLogado");
        // Invalidar o coockes antigo e cria um novo
        session.invalidate();
    }
    
}
