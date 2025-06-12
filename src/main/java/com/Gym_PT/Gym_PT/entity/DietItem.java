package com.Gym_PT.Gym_PT.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DietItems")
public class DietItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private DietLog dietLog;

    private String name;
    private float quantity;
    private float kcal;
    private float carb;
    private float prot;
    private float fat;
}
