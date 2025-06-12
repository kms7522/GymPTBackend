package com.Gym_PT.Gym_PT.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SetWrokoutLogs")
public class SetWorkoutLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "each_id")
    private EachWorkoutLog eachWorkoutLog;

    @Column(name = "set_number")
    private int setNumber;

    private int reps;
    private float weight;

    @Column(name = "is_completed")
    private boolean isCompleted;

    private int duration;
    private int breaktime;
}
