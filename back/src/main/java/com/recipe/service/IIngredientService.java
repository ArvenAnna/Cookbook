package com.recipe.service;

import com.recipe.entity.Ingredient;

import java.util.List;

public interface IIngredientService {

    Ingredient saveIngredient(Ingredient ingredient);

    void deleteIngredient(Long ingId);

    List<Ingredient> showAllIngredients();

    List<Ingredient> searchIngredients(String str);
}
