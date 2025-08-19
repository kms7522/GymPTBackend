package com.Gym_PT.Gym_PT.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class RunningRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String runningName;
    private Float speed;
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "workout_record_id")
    private WorkoutRecord workoutRecord;
}
