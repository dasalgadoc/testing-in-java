package com.dasalgadco.testinjava.integration.infrastructure.database;

import com.dasalgadco.testinjava.integration.domain.Student;
import com.dasalgadco.testinjava.integration.domain.StudentId;
import com.dasalgadco.testinjava.integration.repository.StudentRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

@Component("MySQLStudentRepository")
@EnableAutoConfiguration
public class MySQLStudentRepository implements StudentRepository {

  @Autowired private MySqlStudentCrudRepository mySqlStudentCrudRepository;

  @Override
  public void save(Student student) {
    mySqlStudentCrudRepository.save(StudentEntity.aggregateToEntity(student));
  }

  @Override
  public Student search(StudentId id) {
    Optional<StudentEntity> returned = mySqlStudentCrudRepository.findById(id.value());
    if (!returned.isPresent()) {
      throw new RuntimeException("Student not found");
    }
    return returned.get().entityToAggregate();
  }
}
