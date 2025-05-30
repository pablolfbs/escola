package com.pablo.escola.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Professor {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departament department;

    @ManyToOne
    @JoinColumn(name = "title_id")
    private Title title;
    
}
