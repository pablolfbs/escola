package com.pablo.escola.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.escola.model.ClassSchedule;
import com.pablo.escola.repository.ClassScheduleRepository;

@Service
public class HorarioLivreService {

    @Autowired
    private ClassScheduleRepository scheduleRepository;

    public record BlocoHorario(LocalTime inicio, LocalTime fim) {
        public boolean conflita(BlocoHorario outro) {
            return !this.fim.isBefore(outro.inicio) && !this.inicio.isAfter(outro.fim);
        }
    }

    public List<BlocoHorario> gerarBlocosPadrao(LocalTime inicio, LocalTime fim, int duracaoEmMinutos) {
        List<BlocoHorario> blocos = new ArrayList<>();
        LocalTime atual = inicio;
        while (!atual.plusMinutes(duracaoEmMinutos).isAfter(fim)) {
            blocos.add(new BlocoHorario(atual, atual.plusMinutes(duracaoEmMinutos)));
            atual = atual.plusMinutes(duracaoEmMinutos);
        }
        return blocos;
    }

    public List<BlocoHorario> buscarHorariosLivres(Long salaId, String diaSemana) {
        List<ClassSchedule> ocupados = scheduleRepository.findByRoomIdAndDayOfWeek(salaId, diaSemana);

        List<BlocoHorario> blocosOcupados = ocupados.stream()
            .map(o -> new BlocoHorario(o.getStartTime(), o.getEndTime()))
            .toList();

        List<BlocoHorario> blocosPadrao = gerarBlocosPadrao(LocalTime.of(8, 0), LocalTime.of(18, 0), 120);

        return blocosPadrao.stream().filter(padrao -> blocosOcupados.stream().noneMatch(padrao::conflita)).toList();
    }
}

