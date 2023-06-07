package com.dasalgadco.testinjava.integration.infrastructure.database;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface MySqlStudentCrudRepository extends CrudRepository<StudentEntity, String> {
  Optional<StudentEntity> findById(String id);
}
