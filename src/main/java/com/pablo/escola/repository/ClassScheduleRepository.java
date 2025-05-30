package com.pablo.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pablo.escola.model.ClassSchedule;
import com.pablo.escola.model.dto.ProfessorCargaHorariaDTO;

public interface ClassScheduleRepository
        extends org.springframework.data.jpa.repository.JpaRepository<ClassSchedule, Long> {

    // http://localhost:8080/api/salas/1/livres?dia=TERCA
    List<ClassSchedule> findByRoomIdAndDayOfWeek(Long roomId, String dayOfWeek);

    // http://localhost:8080/api/professores/carga-horaria
    @Query("""
                SELECT new com.pablo.escola.model.dto.ProfessorCargaHorariaDTO(p.id, SUM(TIMESTAMPDIFF(MINUTE, cs.startTime, cs.endTime)))
                FROM ClassSchedule cs
                JOIN cs.classEntity c
                JOIN c.professor p
                GROUP BY p.id
            """)
    List<ProfessorCargaHorariaDTO> buscarCargaHorariaPorProfessor();

    @Query("SELECT c FROM ClassSchedule c WHERE c.classEntity.id = :id")
    List<ClassSchedule> findByClassEntityId(@Param("id") Long id);
}
