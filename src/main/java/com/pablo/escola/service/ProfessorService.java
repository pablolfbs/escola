package com.pablo.escola.service;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pablo.escola.model.dto.ProfessorCargaHorariaDTO;
import com.pablo.escola.repository.ClassScheduleRepository;

@Service
public class ProfessorService {

    private final ClassScheduleRepository classScheduleRepository;

    public ProfessorService(ClassScheduleRepository classScheduleRepository) {
        this.classScheduleRepository = classScheduleRepository;
    }

    public Map<Long, Double> calcularCargaHoraria() {
        return classScheduleRepository.findAll().stream()
                                                .filter(cs -> cs.getClassEntity() != null && cs.getClassEntity().getProfessor() != null)
                                                .collect(Collectors.groupingBy(
                                                        cs -> cs.getClassEntity().getProfessor().getId(),
                                                        Collectors.summingDouble(
                                                                cs -> Duration.between(cs.getStartTime(), cs.getEndTime()).toMinutes() / 60.0)));
    }

    public List<ProfessorCargaHorariaDTO> getCargaHorariaPorProfessor() {
        return classScheduleRepository.buscarCargaHorariaPorProfessor();
    }
}
