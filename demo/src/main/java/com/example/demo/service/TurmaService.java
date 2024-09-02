package com.example.demo.service;

import com.example.demo.database.entities.Estudante;
import com.example.demo.database.entities.Turma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {
    private List<Turma> turmas = new ArrayList<>();

    public Turma cadastrarTurma(String nome) {
        Turma turma = new Turma();
        turma.setNome(nome);
        turmas.add(turma);
        return turma;
    }

    public List<Turma> listarTurmas() {
        return turmas;
    }

    public Turma buscarTurmaPorId(Long id) {
        Optional<Turma> turma = turmas.stream().filter(t -> t.getId().equals(id)).findFirst();
        if (turma.isPresent()) {
            return turma.get();
        } else {
            throw new RuntimeException("Turma não encontrada");
        }
    }

    public Turma atualizarTurma(Long id, String novoNome) {
        Turma turma = buscarTurmaPorId(id);
        turma.setNome(novoNome);
        return turma;
    }

    public void removerTurma(Long id) {
        Turma turma = buscarTurmaPorId(id);
        turmas.remove(turma);
    }

    public Estudante adicionarEstudanteNaTurma(Long turmaId, Estudante estudante) {
        Turma turma = buscarTurmaPorId(turmaId);
        estudante.getTurma().add(turma);
        return estudante;
    }

    public Estudante removerEstudanteDaTurma(Long turmaId, Estudante estudante) {
        Turma turma = buscarTurmaPorId(turmaId);
        estudante.getTurma().remove(turma);
        return estudante;

    }
}
