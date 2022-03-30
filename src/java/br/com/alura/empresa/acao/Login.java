/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.empresa.acao;

import br.com.alura.empresa.modelo.Banco;
import br.com.alura.empresa.modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author robson-pc
 */
public class Login extends Acao{
    
    private String page;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Banco banco = new Banco();
        Usuario user = banco.autenticar(login, senha);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogado", user);
            
            page = "redirect:entrada?acao=ListaEmpresas";
        }else{
            page = "redirect:entrada?acao=LoginForm";
        }
            
    }

    @Override
    public String page() {
       return page;
    }

    
}
