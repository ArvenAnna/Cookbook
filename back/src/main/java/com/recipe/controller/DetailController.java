package com.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.dto.RecipeDto;
import com.recipe.service.IDetailService;

//@RestController
public class DetailController {

	//@Autowired
	private IDetailService detailService;

	@RequestMapping(value = {"/recipes/{recipeId}/details"}, method = RequestMethod.POST, headers = "Accept=application/json")
	public RecipeDto addProportionsToRecipe(@PathVariable("recipeId") Long recipeId, @RequestBody List<RecipeDto.DetailDto> details) {
		return detailService.addDetailsToRecipe(recipeId, details);
	}

	@RequestMapping(value = {"/recipes/{recipeId}/details"}, method = RequestMethod.DELETE, headers = "Accept=application/json")
	public RecipeDto deleteProportionsFromRecipe(@PathVariable("recipeId") Long recipeId,
			@RequestBody List<Long> detailIds) {
		return detailService.deleteDetailsFromRecipe(recipeId, detailIds);
	}
}
