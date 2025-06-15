package com.Gym_PT.Gym_PT.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "DietLogs")
public class DietLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "total_kcal")
    private float totalKcal;

    @Column(name = "total_carb")
    private float totalCarb;

    @Column(name = "total_prot")
    private float totalProt;

    @Column(name = "total_fat")
    private float totalFat;

    public enum Type {
        BREAKFAST, LUNCH, DINNER, DESSERT
    }
}
