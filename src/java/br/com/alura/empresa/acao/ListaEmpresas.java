/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.empresa.acao;

import br.com.alura.empresa.modelo.Banco;
import br.com.alura.empresa.modelo.Empresa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author robson-pc
 */
public class ListaEmpresas extends Acao{

    List<Empresa> lista = new ArrayList<>();

    public ListaEmpresas() {
        super("forward:listaEmpresas.jsp");
    }
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Banco banco = new Banco();
            lista = banco.getEmpresas();
            
            lista.sort((o1, o2) -> {
              
                int NameCompare = o1.getNome().compareTo(o2.getNome());
                int DateCompare = o1.getDataAbertura().compareTo(o2.getDataAbertura());
                
                return (NameCompare == 0) ?   DateCompare
                                            : NameCompare; 
            });
            request.setAttribute("empresas", lista );
    }

}
