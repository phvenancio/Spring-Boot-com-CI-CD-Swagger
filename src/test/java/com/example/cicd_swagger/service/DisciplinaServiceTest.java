package com.example.cicd_swagger.service;

import com.example.cicd_swagger.model.Disciplina;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisciplinaServiceTest {

    @Test
    void testListarTodas() {
        DisciplinaService service = new DisciplinaService();
        List<Disciplina> disciplinas = service.listarTodas();
        assertEquals(2, disciplinas.size());
    }

    @Test
    void testBuscarPorId() {
        DisciplinaService service = new DisciplinaService();
        Disciplina d = service.buscarPorId(1L);
        assertNotNull(d);
        assertEquals("Programação Web", d.getNome());
    }

    @Test
    void testCriar() {
        DisciplinaService service = new DisciplinaService();
        Disciplina nova = new Disciplina(null, "Estrutura de Dados");
        Disciplina criada = service.criar(nova);

        assertNotNull(criada.getId());
        assertEquals("Estrutura de Dados", criada.getNome());
    }
}
