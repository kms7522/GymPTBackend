package com.Gym_PT.Gym_PT.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class WorkoutRequestDto {

    private LocalDate date;

    private List<RunningDto> running;
    private List<NonWeightDto> nonWeight;
    private List<WeightDto> weight;

    @Data
    public static class RunningDto {
        private String runningName;
        private Float speed;
        private Integer duration;
    }

    @Data
    public static class NonWeightDto {
        private String nonWeightName;
        private Integer nonWeightSets;
        private Integer nonWeightReps;
    }

    @Data
    public static class WeightDto {
        private String weightName;
        private Integer weightSets;
        private Integer weightReps;
        private Integer weight;
    }
}
