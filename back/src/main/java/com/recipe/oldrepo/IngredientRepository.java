package com.recipe.oldrepo;

import com.recipe.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>{

    List<Ingredient> findByNameIgnoreCase(String name);

    List<Ingredient> findByNameIgnoreCaseContaining(String str);

}
