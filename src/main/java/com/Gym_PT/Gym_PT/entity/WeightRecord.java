package com.Gym_PT.Gym_PT.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class WeightRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String weightName;
    private Integer weightSets;
    private Integer weightReps;
    private Integer weight;

    @ManyToOne
    @JoinColumn(name = "workout_record_id")
    private WorkoutRecord workoutRecord;
}
