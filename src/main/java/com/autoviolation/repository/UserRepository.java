package com.autoviolation.repository;

import com.autoviolation.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository для User class
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
