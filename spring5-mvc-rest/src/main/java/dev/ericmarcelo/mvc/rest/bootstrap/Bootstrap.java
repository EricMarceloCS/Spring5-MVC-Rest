package dev.ericmarcelo.mvc.rest.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.ericmarcelo.mvc.rest.domain.Category;
import dev.ericmarcelo.mvc.rest.domain.Customer;
import dev.ericmarcelo.mvc.rest.domain.Vendor;
import dev.ericmarcelo.mvc.rest.repositories.CategoryRepository;
import dev.ericmarcelo.mvc.rest.repositories.CustomerRepository;
import dev.ericmarcelo.mvc.rest.repositories.VendorRepository;

@Component
public class Bootstrap implements CommandLineRunner {
	
	private CategoryRepository categoryRepository;
	private CustomerRepository customerRepository;
	private VendorRepository vendorRepository;

	@Autowired
	public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
		this.vendorRepository = vendorRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		loadCategories();
		loadCustomers();
		loadVendors();
		
	}
	
	private void loadVendors() {
		Vendor vendor1 = new Vendor();
        vendor1.setName("Vendor 1");
        vendorRepository.save(vendor1);

        Vendor vendor2 = new Vendor();
        vendor2.setName("Vendor 2");
        vendorRepository.save(vendor2);
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
