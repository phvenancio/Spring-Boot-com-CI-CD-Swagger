package com.example.cicd_swagger.service;

import com.example.cicd_swagger.model.Disciplina;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DisciplinaService {

    private Map<Long, Disciplina> db = new HashMap<>();
    private long idCounter = 3;

    public DisciplinaService() {
        db.put(1L, new Disciplina(1L, "Laboratório de Desenvolvimento Web"));
        db.put(2L, new Disciplina(2L, "Integração e Entrega Contínua"));
    }

    public List<Disciplina> listarTodas() {
        return new ArrayList<>(db.values());
    }

    public Disciplina buscarPorId(Long id) {
        return db.get(id);
    }

    public Disciplina criar(Disciplina disciplina) {
        disciplina.setId(idCounter++);
        db.put(disciplina.getId(), disciplina);
        return disciplina;
    }
}
