package com.dasalgadco.testinjava.testdoubles.infrastructure.database;

import com.dasalgadco.testinjava.integration.domain.Student;
import com.dasalgadco.testinjava.integration.domain.StudentId;
import com.dasalgadco.testinjava.integration.repository.StudentRepository;
import org.springframework.stereotype.Component;

@Component("StubStudentRepository")
public class StubStudentRepository implements StudentRepository {
  @Override
  public void save(Student student) {}

  @Override
  public Student search(StudentId id) {
    String name = "John Doe";
    Integer age = 20;

    return new Student(id.value(), name, age);
  }
}
