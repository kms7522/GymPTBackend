package com.Gym_PT.Gym_PT.service;

import com.Gym_PT.Gym_PT.entity.Exercise;
import com.Gym_PT.Gym_PT.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public Optional<Exercise> getById(Long id) {
        return exerciseRepository.findById(id);
    }

    public List<Exercise> getAll() {
        return exerciseRepository.findAll();
    }

    public void delete(Long id) {
        exerciseRepository.deleteById(id);
    }
}
