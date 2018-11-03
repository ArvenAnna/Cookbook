package com.recipe.service;

import java.util.List;

import com.recipe.dto.RecipeDto;

public interface IDetailService {

	RecipeDto addDetailsToRecipe(Long recipeId, List<RecipeDto.DetailDto> details);

	RecipeDto deleteDetailsFromRecipe(Long recipeId, List<Long> detailIds);
}
