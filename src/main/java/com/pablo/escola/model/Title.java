package com.pablo.escola.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Title {

    @Id
    private Long id;
    
    private String name;
    
}
