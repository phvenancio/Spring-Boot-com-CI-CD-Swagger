package com.example.cicd_swagger.controller;

import com.example.cicd_swagger.model.Disciplina;
import com.example.cicd_swagger.service.DisciplinaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Disciplina> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Disciplina buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Disciplina criar(@RequestBody Disciplina disciplina) {
        return service.criar(disciplina);
    }
}
