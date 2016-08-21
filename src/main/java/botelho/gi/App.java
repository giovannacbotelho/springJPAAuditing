package botelho.gi;

import botelho.gi.service.CurrentUserService;
import botelho.gi.repository.CustomerRepository;
import botelho.gi.domain.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args).registerShutdownHook();
	}

	@Autowired
	private CurrentUserService currentUserService;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void run(String... args) {
		
		customerRepository.save(new Customer("Jack", "Bauer"));
		customerRepository.save(new Customer("Chloe", "O'Brian"));		
	
		currentUserService.setCurrentUserToDoe();

		customerRepository.save(new Customer("Kim", "Bauer"));
		customerRepository.save(new Customer("David", "Palmer"));
		customerRepository.save(new Customer("Michelle", "Dessler"));
		
		// fetch all customers
				log.info("Customers found with findAll():");
				log.info("-------------------------------");
				for (Customer customer : customerRepository.findAll()) {
					log.info(customer.toString());
				}
		        log.info("");

				// fetch an individual customer by ID
				Customer customer = customerRepository.findOne(1L);
				log.info("Customer found with findOne(1L):");
				log.info("--------------------------------");
				log.info(customer.toString());
		        log.info("");

				// fetch customers by last name
				log.info("Customer found with findByLastName('Bauer'):");
				log.info("--------------------------------------------");
				for (Customer bauer : customerRepository.findByLastName("Bauer")) {
					log.info(bauer.toString());
				}
		        log.info("");

	}
}
