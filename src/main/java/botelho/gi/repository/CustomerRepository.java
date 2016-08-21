package botelho.gi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import botelho.gi.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}