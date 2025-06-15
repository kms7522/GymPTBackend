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
    public ResponseEntity<String> getRoutine(@RequestParam String goal,
                                             @RequestParam String bodyPart,
                                             @RequestParam String level) {
        String result = gptRoutineService.generateRoutine(goal, bodyPart, level);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/diet")
    public ResponseEntity<String> getMeal(@RequestParam String goal,
                                          @RequestParam(defaultValue = "한국") String style) {
        String result = gptDietService.generateMeal(goal, style);
        return ResponseEntity.ok(result);
    }
}
