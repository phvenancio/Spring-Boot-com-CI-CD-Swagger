package com.example.cicd_swagger.controller;

import com.example.cicd_swagger.model.Disciplina;
import com.example.cicd_swagger.service.DisciplinaService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(DisciplinaController.class)
class DisciplinaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DisciplinaService service;

    @Test
    void testListar() throws Exception {
        when(service.listarTodas()).thenReturn(
                Arrays.asList(
                        new Disciplina(1L, "Laboratório de Desenvolvimento Web"),
                        new Disciplina(2L, "Integração e Entrega Contínua")
                )
        );

        mockMvc.perform(get("/disciplinas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void testBuscarPorId() throws Exception {
        when(service.buscarPorId(1L))
                .thenReturn(new Disciplina(1L, "Laboratório de Desenvolvimento Web"));

        mockMvc.perform(get("/disciplinas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Laboratório de Desenvolvimento Web"));
    }

    @Test
    void testCriar() throws Exception {
        Disciplina input = new Disciplina(null, "Programação para Dispositivos Móveis");
        Disciplina output = new Disciplina(3L, "Programação para Dispositivos Móveis");

        when(service.criar(any())).thenReturn(output);

        mockMvc.perform(
                post("/disciplinas")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(input))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.nome").value("Programação para Dispositivos Móveis"));
    }
}
