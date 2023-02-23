package dev.ericmarcelo.mvc.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ericmarcelo.mvc.rest.api.v1.model.CustomerDTO;
import dev.ericmarcelo.mvc.rest.domain.Customer;
import dev.ericmarcelo.mvc.rest.repositories.CustomerRepository;
import dev.ericmarcelo.mvc.rest.v1.mapper.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;
	private String BASE_URL = "/api/v1/customer/";
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		super();
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		
		return this.customerRepository
				.findAll()
				.stream()
				.map(customerMapper::customerToCustomerDTO)
				.toList();
	}

	@Override
	public CustomerDTO getCustomerById(Long id) {
		return this.customerMapper.customerToCustomerDTO(customerRepository.findById(id).orElseThrow());
	}

	@Override
	public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
		
		return saveAndReturnDTO(customerMapper.customerDTOToCustomer(customerDTO));
	}

	@Override
	public CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO) {
		Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
		customer.setId(id);
		return saveAndReturnDTO(customer);
	}
	
	private CustomerDTO saveAndReturnDTO(Customer customer) {
		Customer savedCustomer = customerRepository.save(customer);
		CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(savedCustomer);
		
		customerDTO.setCustomerUrl(BASE_URL + savedCustomer.getId());
		
		return customerDTO;
	}

	@Override
	public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		if(optionalCustomer.isEmpty()) {
			return null;
		}
		Customer customer = optionalCustomer.get();
		if(customerDTO.getFirstName() != null) {
			customer.setFirstName(customerDTO.getFirstName());
		}
		if(customerDTO.getLastName() != null) {
			customer.setLastName(customerDTO.getLastName());
		}
		
		CustomerDTO returnedDto = customerMapper.customerToCustomerDTO(customer);
		
		returnedDto.setCustomerUrl(BASE_URL + id);
		
		return returnedDto;
		
	}

	@Override
	public void deleteCustomerById(Long id) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		if(optionalCustomer.isEmpty()) {
			return;
		}
		customerRepository.delete(optionalCustomer.get());
		
	}

}
