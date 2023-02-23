package dev.ericmarcelo.mvc.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ericmarcelo.mvc.rest.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
