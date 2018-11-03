package com.recipe.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.dto.RecipeDto;
import com.recipe.entity.Proportion;
import com.recipe.entity.Recipe;
import com.recipe.exception.Errors;
import com.recipe.oldrepo.RecipeRepository;
import com.recipe.service.IProportionService;

//@Service
public class ProportionService implements IProportionService {

	//@Autowired
	private RecipeRepository recipeRep;

	@Override
	@Transactional
	public RecipeDto addProportionsToRecipe(Long recipeId, List<RecipeDto.ProportionDto> proportions) {
		Recipe recipe = recipeRep.findById(recipeId).orElseThrow(() -> new EntityNotFoundException(Errors.RECIPE_NOT_FOUND.getCause()));
		List<Proportion> proportionsToAdd = proportions.stream().map(prop -> Proportion.of(prop, recipe)).collect(Collectors.toList());
		recipe.getProportions().addAll(proportionsToAdd);
		return RecipeDto.withAllFields(recipeRep.saveAndFlush(recipe));
	}

	@Override
	@Transactional
	public RecipeDto deleteProportionsFromRecipe(Long recipeId, List<Long> proportionIds) {
		Recipe recipe = recipeRep.findById(recipeId).orElseThrow(() -> new EntityNotFoundException(Errors.RECIPE_NOT_FOUND.getCause()));
		List<Proportion> proportionsToRemove = recipe.getProportions().stream()
				.filter(prop -> proportionIds.contains(prop.getId())).collect(Collectors.toList());

		recipe.getProportions().removeAll(proportionsToRemove);
		return RecipeDto.withAllFields(recipeRep.saveAndFlush(recipe));
	}
}
