package com.Gym_PT.Gym_PT.service;

import com.Gym_PT.Gym_PT.dto.WorkoutRequestDto;
import com.Gym_PT.Gym_PT.dto.WorkoutResponseDto;
import com.Gym_PT.Gym_PT.entity.*;
import com.Gym_PT.Gym_PT.repository.UserRepository;
import com.Gym_PT.Gym_PT.repository.WorkoutRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final UserRepository userRepository;
    private final WorkoutRecordRepository workoutRecordRepository;

    @Transactional
    public WorkoutRequestDto saveWorkout(Long userId, WorkoutRequestDto dto) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        WorkoutRecord workoutRecord = new WorkoutRecord();
        workoutRecord.setUser(user);
        workoutRecord.setWorkoutDate(dto.getDate());

        if (dto.getRunning() != null) {
            for (WorkoutRequestDto.RunningDto r : dto.getRunning()) {
                RunningRecord run = new RunningRecord();
                run.setRunningName(r.getRunningName());
                run.setSpeed(r.getSpeed());
                run.setDuration(r.getDuration());
                run.setWorkoutRecord(workoutRecord); // 양방향 관계 설정
                workoutRecord.getRunningRecords().add(run);
            }
        }

        if (dto.getNonWeight() != null) {
            for (WorkoutRequestDto.NonWeightDto n : dto.getNonWeight()) {
                NonWeightRecord non = new NonWeightRecord();
                non.setNonWeightName(n.getNonWeightName());
                non.setNonWeightSets(n.getNonWeightSets());
                non.setNonWeightReps(n.getNonWeightReps());
                non.setWorkoutRecord(workoutRecord);
                workoutRecord.getNonWeightRecords().add(non);
            }
        }

        if (dto.getWeight() != null) {
            for (WorkoutRequestDto.WeightDto w : dto.getWeight()) {
                WeightRecord weight = new WeightRecord();
                weight.setWeightName(w.getWeightName());
                weight.setWeightSets(w.getWeightSets());
                weight.setWeightReps(w.getWeightReps());
                weight.setWeight(w.getWeight());
                weight.setWorkoutRecord(workoutRecord);
                workoutRecord.getWeightRecords().add(weight);
            }
        }

        workoutRecordRepository.save(workoutRecord);

        return dto;
    }
    @Transactional(readOnly = true)
    public WorkoutResponseDto getWorkoutByUserAndDate(Long userId, LocalDate date) {
        WorkoutRecord record = workoutRecordRepository
                .findByUserIdAndWorkoutDate(userId, date)
                .orElseThrow(() -> new IllegalArgumentException("운동 기록이 없습니다."));

        WorkoutResponseDto dto = new WorkoutResponseDto();
        dto.setUserId(userId);
        dto.setDate(record.getWorkoutDate());

        // Running
        dto.setRunning(record.getRunningRecords().stream().map(r -> {
            WorkoutRequestDto.RunningDto d = new WorkoutRequestDto.RunningDto();
            d.setRunningName(r.getRunningName());
            d.setSpeed(r.getSpeed());
            d.setDuration(r.getDuration());
            return d;
        }).toList());

        // NonWeight
        dto.setNonWeight(record.getNonWeightRecords().stream().map(n -> {
            WorkoutRequestDto.NonWeightDto d = new WorkoutRequestDto.NonWeightDto();
            d.setNonWeightName(n.getNonWeightName());
            d.setNonWeightSets(n.getNonWeightSets());
            d.setNonWeightReps(n.getNonWeightReps());
            return d;
        }).toList());

        // Weight
        dto.setWeight(record.getWeightRecords().stream().map(w -> {
            WorkoutRequestDto.WeightDto d = new WorkoutRequestDto.WeightDto();
            d.setWeightName(w.getWeightName());
            d.setWeightSets(w.getWeightSets());
            d.setWeightReps(w.getWeightReps());
            d.setWeight(w.getWeight());
            return d;
        }).toList());

        return dto;
    }

    @Transactional
    public void deleteWorkoutByUserAndDate(Long userId, LocalDate date) {
        WorkoutRecord record = workoutRecordRepository
                .findByUserIdAndWorkoutDate(userId, date)
                .orElseThrow(() -> new IllegalArgumentException("운동 기록이 존재하지 않습니다."));

        workoutRecordRepository.delete(record);
    }
}
