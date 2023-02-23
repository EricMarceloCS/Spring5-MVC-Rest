package dev.ericmarcelo.mvc.rest.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import dev.ericmarcelo.mvc.rest.api.v1.model.CustomerDTO;
import dev.ericmarcelo.mvc.rest.domain.Customer;

@Mapper
public interface CustomerMapper {
	
	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

	CustomerDTO customerToCustomerDTO(Customer customer);
	
	Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
