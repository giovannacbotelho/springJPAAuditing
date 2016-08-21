package botelho.gi.repository;

import org.springframework.data.repository.CrudRepository;

import botelho.gi.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
