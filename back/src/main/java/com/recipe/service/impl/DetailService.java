package com.recipe.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.dto.RecipeDto;
import com.recipe.entity.Detail;
import com.recipe.entity.Recipe;
import com.recipe.exception.Errors;
import com.recipe.oldrepo.RecipeRepository;
import com.recipe.service.IDetailService;

//@Service
public class DetailService implements IDetailService {

	//@Autowired
	private RecipeRepository recipeRep;

	@Override
	@Transactional
	public RecipeDto addDetailsToRecipe(Long recipeId, List<RecipeDto.DetailDto> details) {
		Recipe recipe = recipeRep.findById(recipeId).orElseThrow(() -> new EntityNotFoundException(Errors.RECIPE_NOT_FOUND.getCause()));

		List<Detail> detailsToAdd = details.stream().map(detail -> Detail.of(detail, recipe)).collect(Collectors.toList());

		recipe.getDetails().addAll(detailsToAdd);
		return RecipeDto.withAllFields(recipeRep.saveAndFlush(recipe));
	}

	@Override
	@Transactional
	public RecipeDto deleteDetailsFromRecipe(Long recipeId, List<Long> detailIds) {
		Recipe recipe = recipeRep.findById(recipeId).orElseThrow(() -> new EntityNotFoundException(Errors.RECIPE_NOT_FOUND.getCause()));
		List<Detail> detailsToRemove = recipe.getDetails().stream()
				.filter(detail -> detailIds.contains(detail.getId())).collect(Collectors.toList());

		recipe.getDetails().removeAll(detailsToRemove);
		return RecipeDto.withAllFields(recipeRep.saveAndFlush(recipe));
	}
}
