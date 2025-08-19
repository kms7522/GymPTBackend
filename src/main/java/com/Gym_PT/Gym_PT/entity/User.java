package com.Gym_PT.Gym_PT.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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

    @Enumerated(EnumType.STRING)
    private ExperienceLevel experienceLevel;

    private Integer duration;
    private String location;
    private String splitStrategy;

    public enum Gender {
        MALE, FEMALE
    }

    public enum Goal {
        DIET, BULK, KEEP
    }

    public enum ExperienceLevel {
        BEGINNER, INTERMEDIATE, ADVANCED
    }
}
