package dev.ericmarcelo.mvc.rest.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.ericmarcelo.mvc.rest.domain.Category;
import dev.ericmarcelo.mvc.rest.domain.Customer;
import dev.ericmarcelo.mvc.rest.repositories.CategoryRepository;
import dev.ericmarcelo.mvc.rest.repositories.CustomerRepository;

@Component
public class Bootstrap implements CommandLineRunner {
	
	private CategoryRepository categoryRepository;
	private CustomerRepository customerRepository;

	@Autowired
	public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		loadCategories();
		loadCustomers();
		
	}
	
	private void loadCategories() {
		Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);


        System.out.println("Data Loaded = " + categoryRepository.count());
	}
	
	private void loadCustomers() {
		 Customer customer1 = new Customer();
		 customer1.setId(1l);
		 customer1.setFirstName("Michale");
		 customer1.setLastName("Weston");
		 customerRepository.save(customer1);

		 Customer customer2 = new Customer();
		 customer2.setId(2l);
		 customer2.setFirstName("Sam");
		 customer2.setLastName("Axe");

		 customerRepository.save(customer2);

		 System.out.println("Customers Loaded: " + customerRepository.count());
	}
	

}
