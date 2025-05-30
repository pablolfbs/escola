package com.pablo.escola.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.escola.model.dto.ProfessorCargaHorariaDTO;
import com.pablo.escola.service.ProfessorService;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/carga-horaria")
    public List<ProfessorCargaHorariaDTO> buscarCargaHorariaPorProfessor() {
        return professorService.getCargaHorariaPorProfessor();
    }
}
