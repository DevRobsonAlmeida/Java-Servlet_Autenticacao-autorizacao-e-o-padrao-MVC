package br.com.alura.empresa.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {

    private static List<Empresa> lista = new ArrayList<>();
    private static List<Usuario> listaUsuarios = new ArrayList<>();
    private static Integer chaveSequencial = 1;

    static {
        Empresa empresa = new Empresa();
        empresa.setId(Banco.chaveSequencial++);
        empresa.setNome("Alura");
        Banco.lista.add(empresa);
        
        Usuario u1 = new Usuario();
        u1.setLogin("nico");
        u1.setSenha("123");
        
        Usuario u2 = new Usuario();
        u2.setLogin("ana");
        u2.setSenha("123");
        
        listaUsuarios.add(u1);
        listaUsuarios.add(u2);
        
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(Banco.chaveSequencial++);
        Banco.lista.add(empresa);
    }

    public List<Empresa> getEmpresas() {
        return Banco.lista;
    }

    public void removeEmpresa(Integer id) {
        Banco.lista.removeIf(e -> e.getId() == id);
    }

    public Empresa consultarEmpresaId(Integer id) {
        return Banco.lista.stream()
                .filter(c -> c.getId() == id)
                .sorted((o1, o2) -> o1.getNome().compareTo(o2.getNome()))
                .collect(Collectors.toList())                
                .get(0);
    }


    public Usuario autenticar(String login, String senha){
//        listaUsuarios.stream().filter( user -> user.ehIgual(login, senha)).isParallel();
        return listaUsuarios.stream().filter( user -> user.ehIgual(login, senha)).findAny().orElse(null);
    }
    
}
