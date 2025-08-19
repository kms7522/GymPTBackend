package com.Gym_PT.Gym_PT.controller;

import com.Gym_PT.Gym_PT.dto.WorkoutRequestDto;
import com.Gym_PT.Gym_PT.dto.WorkoutResponseDto;
import com.Gym_PT.Gym_PT.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @PostMapping("/{userId}/workout")
    public ResponseEntity<WorkoutRequestDto> saveWorkout(
            @PathVariable Long userId,
            @RequestBody WorkoutRequestDto request) {

        WorkoutRequestDto savedWorkout = workoutService.saveWorkout(userId, request);
        return ResponseEntity.ok(savedWorkout);
    }

    @GetMapping("/{userId}/workout")
    public ResponseEntity<WorkoutResponseDto> getWorkoutByDate(
            @PathVariable Long userId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        WorkoutResponseDto result = workoutService.getWorkoutByUserAndDate(userId, date);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{userId}/workout")
    public ResponseEntity<Void> deleteWorkoutByDate(
            @PathVariable Long userId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        workoutService.deleteWorkoutByUserAndDate(userId, date);
        return ResponseEntity.noContent().build(); // 204 응답
    }


}
