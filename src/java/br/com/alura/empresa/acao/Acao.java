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

/**
 *
 * @author robson-pc
 */
public abstract class Acao {
   
    protected String page;

    public Acao(String page) {
        this.page = page;
    }

    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public String getPage() {
        return page; 
    }

    

    
    
}
