package com.Gym_PT.Gym_PT.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class WorkoutResponseDto {
    private Long userId;
    private LocalDate date;
    private List<WorkoutRequestDto.RunningDto> running;
    private List<WorkoutRequestDto.NonWeightDto> nonWeight;
    private List<WorkoutRequestDto.WeightDto> weight;
}