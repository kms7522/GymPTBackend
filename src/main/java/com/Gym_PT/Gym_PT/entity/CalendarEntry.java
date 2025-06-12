package com.Gym_PT.Gym_PT.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Calendar")
@IdClass(CalendarId.class)
public class CalendarEntry {

    @Id
    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @Id
    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "today_kcal")
    private Float todayKcal;

    @Column(name = "today_carb")
    private Float todayCarb;

    @Column(name = "today_prot")
    private Float todayProt;

    @Column(name = "today_fat")
    private Float todayFat;

    @Column(name = "goal_rate")
    private Float goalRate;

    public CalendarEntry() {}
}