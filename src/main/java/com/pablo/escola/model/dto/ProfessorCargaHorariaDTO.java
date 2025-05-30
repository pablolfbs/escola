package com.pablo.escola.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfessorCargaHorariaDTO {

    private Long professorId;
    private Long totalMinutos;
    
}
