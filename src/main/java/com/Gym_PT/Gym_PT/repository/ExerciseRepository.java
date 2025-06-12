package com.Gym_PT.Gym_PT.repository;

import com.Gym_PT.Gym_PT.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
