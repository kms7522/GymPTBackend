package com.Gym_PT.Gym_PT.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "EachWorkoutLogs")
public class EachWorkoutLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "daily_id")
    private DailyWorkoutLog dailyWorkoutLog;

    @Column(name = "set_count")
    private int setCount;

    @Column(name = "goal_rate")
    private Float goalRate;

    @Column(name = "total_time")
    private int totalTime;

    @Column(name = "max_weight")
    private Float maxWeight;
}
