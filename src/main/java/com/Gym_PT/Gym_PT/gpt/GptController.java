package com.Gym_PT.Gym_PT.gpt;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gpt")
@RequiredArgsConstructor
public class GptController {

    private final GptRoutineService gptRoutineService;
    private final GptDietService gptDietService;

    @PostMapping("/routine")
    public ResponseEntity<String> getRoutine(
            @RequestParam(name = "age") int age,
            @RequestParam(name = "gender") String gender,
            @RequestParam(name = "height") int height,
            @RequestParam(name = "weight") int weight,
            @RequestParam(name = "goal") String goal,
            @RequestParam(name = "bodyPart") String bodyPart,
            @RequestParam(name = "level") String level
    ) {
        String result = gptRoutineService.generateRoutine(age, gender, height, weight, goal, bodyPart, level);
        return ResponseEntity.ok(result);
    }



    @PostMapping("/diet")
    public ResponseEntity<String> getDiet(
            @RequestParam(name = "age") int age,
            @RequestParam(name = "gender") String gender,
            @RequestParam(name = "height") int height,
            @RequestParam(name = "weight") int weight,
            @RequestParam(name = "goal") String goal,
            @RequestParam(name = "mealType") String mealType
    ) {
        String result = gptDietService.generateDiet(age, gender, height, weight, goal, mealType);
        return ResponseEntity.ok(result);
    }


}