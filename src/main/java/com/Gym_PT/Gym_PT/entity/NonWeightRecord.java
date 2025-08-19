package com.Gym_PT.Gym_PT.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class NonWeightRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nonWeightName;
    private Integer nonWeightSets;
    private Integer nonWeightReps;

    @ManyToOne
    @JoinColumn(name = "workout_record_id")
    private WorkoutRecord workoutRecord;
}
