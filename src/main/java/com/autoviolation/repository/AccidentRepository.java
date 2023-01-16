package com.autoviolation.repository;

import com.autoviolation.model.Accident;
import org.springframework.data.repository.CrudRepository;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {
}
