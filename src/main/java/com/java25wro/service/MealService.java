package com.java25wro.service;

import com.java25wro.model.Meal;
import com.java25wro.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class MealService implements IMealService {

    private MealRepository mealRepository;

    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Transactional
    @Override
    public List<Meal> findAll() {
        return mealRepository.findAll();
    }

    //TODO
    //wyszukać wszystkie posiłki z danej restauracji
    @Transactional
    @Override
    public Set<Meal> findMealsByRestaurantId(Long restaurantId) {
        return mealRepository.findAllByRestaurantId(restaurantId);
    }

    @Transactional
    @Override
    public Meal findMealByMealId(Long mealId) {
        return mealRepository.findById(mealId).orElse(new Meal("Zupa", new BigDecimal(22),
                "turururu", "tutututu", "turururu"));
    }

    @Transactional
    @Override
    public void createMeal(Meal newMeal) {
        mealRepository.save(newMeal);
    }

    @Transactional
    @Override
    public void deleteMeal(Long mealId) {
        Meal mealToDelete = mealRepository.findById(mealId).get();
        mealToDelete.setDeleted(true);
        mealRepository.save(mealToDelete);
    }
}
