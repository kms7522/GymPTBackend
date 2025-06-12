package com.Gym_PT.Gym_PT.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "DailyWorkoutLogs")
public class DailyWorkoutLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime date;

    @Column(name = "goal_rate")
    private Float goalRate;

    @Column(name = "total_time")
    private Float totalTime;
}
