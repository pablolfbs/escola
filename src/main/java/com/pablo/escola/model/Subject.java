package com.pablo.escola.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Subject {

    @Id
    private Long id;

    @Column(name = "subject_id")
    private String subjectId;
    
    private String code;
    private String name;

}
