package dev.ericmarcelo.mvc.rest.v1.mapper;

import org.springframework.stereotype.Component;

import dev.ericmarcelo.mvc.rest.api.v1.model.CustomerDTO;
import dev.ericmarcelo.mvc.rest.domain.Customer;

@Component
public class CustomerMapperImpl implements CustomerMapper {

	@Override
	public CustomerDTO customerToCustomerDTO(Customer customer) {
		if(customer == null) {
			return null;
		}
		
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setFirstName(customer.getFirstName());
		customerDTO.setLastName(customer.getLastName());
		
		return customerDTO;
	}

	@Override
	public Customer customerDTOToCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		
		return customer;
	}
	
	

}
