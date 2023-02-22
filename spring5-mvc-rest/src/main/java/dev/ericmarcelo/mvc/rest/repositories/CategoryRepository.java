package dev.ericmarcelo.mvc.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ericmarcelo.mvc.rest.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByName(String anyString);

}
