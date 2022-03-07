package br.com.alura.empresa.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {

    private static List<Empresa> lista = new ArrayList<>();
    private static Integer chaveSequencial = 1;

    static {
        Empresa empresa = new Empresa();
        empresa.setId(Banco.chaveSequencial++);
        empresa.setNome("Alura");
        Banco.lista.add(empresa);
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

    public Empresa consultarId(Integer id) {
        return Banco.lista.stream()
                .filter(c -> c.getId() == id)
                .collect(Collectors.toList())
                .get(0);
    }

}
