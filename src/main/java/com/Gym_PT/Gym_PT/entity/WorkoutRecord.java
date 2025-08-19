package com.Gym_PT.Gym_PT.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class WorkoutRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate workoutDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "workoutRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RunningRecord> runningRecords = new ArrayList<>();

    @OneToMany(mappedBy = "workoutRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NonWeightRecord> nonWeightRecords = new ArrayList<>();

    @OneToMany(mappedBy = "workoutRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeightRecord> weightRecords = new ArrayList<>();
}
