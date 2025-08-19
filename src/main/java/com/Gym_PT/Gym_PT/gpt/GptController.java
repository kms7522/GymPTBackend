package com.Gym_PT.Gym_PT.gpt;

import com.Gym_PT.Gym_PT.entity.User;
import com.Gym_PT.Gym_PT.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gpt")
@RequiredArgsConstructor
public class GptController {

    private final GptRoutineService gptRoutineService;
    private final GptDietService gptDietService;
    private final UserService userService;

    @GetMapping("/routine/{userId}")
    public ResponseEntity<String> getRoutine(@PathVariable("userId") Long userId) {
        User user = userService.getUser(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        String result = gptRoutineService.generateRoutine(user);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/diet/{userId}")
    public ResponseEntity<String> getDiet(@PathVariable Long userId) {
        User user = userService.getUser(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        String result = gptDietService.generateDiet(user); // ← 오버로드 사용
        return ResponseEntity.ok(result);
    }
}
