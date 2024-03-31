package com.example.food;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/foods")
public class FoodController {
    private final FoodService foodService;

    @PostMapping("/save")
    public Food saveFood(@RequestBody Food food) {
        return foodService.saveFood(food);
    }

    @GetMapping("/findAll")
    public List<Food> findAllFoods() {
        return foodService.findAllFoods();
    }

    @GetMapping("/find/{foodId}")
    public Food findFoodById(@PathVariable String foodId) {
        return foodService.findFoodById(foodId);
    }

    @GetMapping("/greeter")
    public String greeter() {
        return "Hello from Food Service!";
    }
}
