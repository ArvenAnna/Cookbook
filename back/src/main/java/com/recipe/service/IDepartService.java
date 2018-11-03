package com.recipe.service;

import com.recipe.dto.RecipeDto;
import com.recipe.entity.Department;

import java.util.List;

public interface IDepartService {
    List<Department> findAllDepartments();
    Department createNewDepartment(Department department);
    void deleteDepartment(Integer id);
    List<RecipeDto> findRecipesByDepart(Integer id);
}
