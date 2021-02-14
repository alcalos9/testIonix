package cl.ionix.test.test.repository;

import org.springframework.data.repository.CrudRepository;

import cl.ionix.test.test.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
