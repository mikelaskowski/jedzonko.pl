package com.java25wro.repository;

import com.java25wro.model.OrderedMeals;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface OrderedMealsRepository extends CrudRepository<OrderedMeals, Long> {

    Set<OrderedMeals> findAllMealsByOrderId(Long orderId);
}
