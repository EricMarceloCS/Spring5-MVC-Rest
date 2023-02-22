package dev.ericmarcelo.mvc.rest.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import dev.ericmarcelo.mvc.rest.api.v1.model.CategoryDTO;
import dev.ericmarcelo.mvc.rest.domain.Category;

@Mapper
public interface CategoryMapper {

	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
	
	CategoryDTO categoryToCategoryDTO(Category category);
}
