package dev.ericmarcelo.mvc.rest;

import dev.ericmarcelo.mvc.rest.api.v1.model.CategoryDTO;
import dev.ericmarcelo.mvc.rest.controllers.v1.CategoryController;
import dev.ericmarcelo.mvc.rest.domain.Category;
import dev.ericmarcelo.mvc.rest.repositories.CategoryRepository;
import dev.ericmarcelo.mvc.rest.services.CategoryService;
import dev.ericmarcelo.mvc.rest.services.CategoryServiceImpl;
import dev.ericmarcelo.mvc.rest.v1.mapper.CategoryMapper;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class CategoryServiceTest {

	public static final Long ID = 2L;
	public static final String NAME = "Jimmy";
	@Mock
	CategoryService categoryService;
	
	@Mock
	CategoryRepository categoryRepository;
	
	@InjectMocks
	CategoryController categoryController;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		this.categoryService = new CategoryServiceImpl(categoryRepository, CategoryMapper.INSTANCE);
		
		mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
	}
	
	@Test
	public void testListcategories() throws Exception {
		CategoryDTO category1 = new CategoryDTO();
		category1.setId(1L);
		category1.setName(NAME);
		
		CategoryDTO category2 = new CategoryDTO();
		category2.setId(2L);
		category2.setName("Bob");
		
		List<CategoryDTO> categories = new ArrayList<>();
		categories.add(category1);
		categories.add(category2);
		
		when(categoryService.getAllCategories()).thenReturn(categories);
		
		mockMvc.perform( get("/api/v1/categories")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
	}
	
	@Test
	public void testGetByNameCategories() throws Exception {
		Category category1 = new Category();
		category1.setId(1L);
		category1.setName(NAME);
		
		when(categoryRepository.findByName(anyString())).thenReturn(category1);
		
		mockMvc.perform(get("/api/v1/categories/Jim")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", equalTo(NAME)));
	}
	
	@Test
	public void getAllCategories() throws Exception {
		
		List<Category> categories = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			categories.add(new Category());
		}
		
		when(categoryRepository.findAll()).thenReturn(categories);
		
		List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();
		
		assertEquals(3, categoryDTOS.size());
		
	}
	
	@Test
	public void getCategoryByName() throws Exception {
		Category category = new Category();
		category.setId(ID);
		category.setName(NAME);
		
		when(categoryRepository.findByName(anyString())).thenReturn(category);
		
		CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);
		
		assertEquals(ID, categoryDTO.getId());
		assertEquals(NAME, categoryDTO.getName());
	}
}
