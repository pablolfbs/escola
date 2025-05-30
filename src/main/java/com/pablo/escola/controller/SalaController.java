package com.pablo.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.escola.service.HorarioLivreService;

@RestController
@RequestMapping("/api/salas")
class SalaController {

    @Autowired
    private HorarioLivreService horarioService;

    @GetMapping("/{salaId}/livres")
    public List<HorarioLivreService.BlocoHorario> getHorariosLivres(@PathVariable Long salaId, @RequestParam String dia) {
        return horarioService.buscarHorariosLivres(salaId, dia.toUpperCase());
    }
}
