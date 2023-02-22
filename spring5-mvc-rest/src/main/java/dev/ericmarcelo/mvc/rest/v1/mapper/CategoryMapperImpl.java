package dev.ericmarcelo.mvc.rest.v1.mapper;

import org.springframework.stereotype.Component;

import dev.ericmarcelo.mvc.rest.api.v1.model.CategoryDTO;
import dev.ericmarcelo.mvc.rest.domain.Category;

@Component
public class CategoryMapperImpl implements CategoryMapper {

	@Override
	public CategoryDTO categoryToCategoryDTO(Category category) {
		if (category  == null) {
			return null;
		}
		
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		
		return categoryDTO;
	}

}
