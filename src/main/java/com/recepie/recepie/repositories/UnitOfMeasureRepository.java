package com.recepie.recepie.repositories;

import com.recepie.recepie.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{


    Optional<UnitOfMeasure> findByDescription(String description);
}
