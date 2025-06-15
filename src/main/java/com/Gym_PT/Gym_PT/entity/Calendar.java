package com.Gym_PT.Gym_PT.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Calendars", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "date"})
})
@Getter
@Setter
@NoArgsConstructor
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDate date;

    private Float todayKcal;
    private Float todayCarb;
    private Float todayProt;
    private Float todayFat;
    private Float goalRate;
}
