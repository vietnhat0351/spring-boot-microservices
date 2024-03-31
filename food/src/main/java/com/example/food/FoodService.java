package com.example.food;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;

    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    public List<Food> findAllFoods() {
        return foodRepository.findAll();
    }

    public Food findFoodById(String foodId) {
        return foodRepository.findById(foodId).orElse(null);
    }

}
