package dev.ericmarcelo.mvc.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ericmarcelo.mvc.rest.api.v1.model.CategoryDTO;
import dev.ericmarcelo.mvc.rest.repositories.CategoryRepository;
import dev.ericmarcelo.mvc.rest.v1.mapper.CategoryMapper;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
		super();
		this.categoryRepository = categoryRepository;
		this.categoryMapper = categoryMapper;
	}

	@Override
	public List<CategoryDTO> getAllCategories() {

		return this.categoryRepository.findAll()
				.stream()
				.map(categoryMapper::categoryToCategoryDTO)
				.toList();
	}

	@Override
	public CategoryDTO getCategoryByName(String name) {
		return this.categoryMapper.categoryToCategoryDTO(categoryRepository.findByName(name));
	}

}
