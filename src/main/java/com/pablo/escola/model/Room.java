package com.pablo.escola.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Room {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
    
}
