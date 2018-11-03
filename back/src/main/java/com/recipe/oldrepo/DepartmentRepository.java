package com.recipe.oldrepo;

import com.recipe.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	Department findByNameIgnoreCase(String name);
}
