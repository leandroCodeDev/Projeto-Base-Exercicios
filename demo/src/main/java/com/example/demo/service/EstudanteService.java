package com.example.demo.service;

import com.example.demo.database.entities.Estudante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {
    private List<Estudante> estudantes = new ArrayList<>();

    public Estudante cadastrarEstudante(String nome, String matricula) {
        Estudante estudante = new Estudante();
        estudante.setNome(nome);
        estudante.setMatricula(matricula);
        estudantes.add(estudante);
        return estudante;
    }

    public List<Estudante> listarEstudantes() {
        return estudantes;
    }

    public Estudante buscarEstudantePorId(Long id) {
        Optional<Estudante> estudante = estudantes.stream().filter(e -> e.getId().equals(id)).findFirst();
        if (estudante.isPresent()) {
            return estudante.get();
        } else {
            throw new RuntimeException("Estudante não encontrado");
        }
    }

    public Estudante atualizarEstudante(Long id, String novoNome, String novaMatricula) {
        Estudante estudante = buscarEstudantePorId(id);
        estudante.setNome(novoNome);
        estudante.setMatricula(novaMatricula);
        return estudante;
    }

    public void removerEstudante(Long id) {
        Estudante estudante = buscarEstudantePorId(id);
        estudantes.remove(estudante);
    }
}
