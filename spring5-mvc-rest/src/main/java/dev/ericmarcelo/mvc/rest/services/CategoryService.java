package dev.ericmarcelo.mvc.rest.services;

import java.util.List;

import dev.ericmarcelo.mvc.rest.api.v1.model.CategoryDTO;

public interface CategoryService {

	List<CategoryDTO> getAllCategories();
	
	CategoryDTO getCategoryByName(String name);
}
