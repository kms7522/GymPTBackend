package com.Gym_PT.Gym_PT.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Float height;
    private Float weight;

    @Enumerated(EnumType.STRING)
    private Goal goal;

    // getters, setters

    public enum Gender {
        MALE, FEMALE
    }

    public enum Goal {
        DIET, BULK, KEEP
    }
}
