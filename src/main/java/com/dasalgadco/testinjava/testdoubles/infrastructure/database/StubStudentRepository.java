package com.dasalgadco.testinjava.testdoubles.infrastructure.database;

import com.dasalgadco.testinjava.integration.domain.Student;
import com.dasalgadco.testinjava.integration.domain.StudentAge;
import com.dasalgadco.testinjava.integration.domain.StudentId;
import com.dasalgadco.testinjava.integration.domain.StudentName;
import com.dasalgadco.testinjava.integration.repository.StudentRepository;
import org.springframework.stereotype.Component;

@Component("StubStudentRepository")
public class StubStudentRepository implements StudentRepository {
  @Override
  public void save(Student student) {}

  @Override
  public Student search(StudentId id) {
    StudentName studentName = new StudentName("John Doe");
    StudentAge studentAge = new StudentAge(20);

    return new Student(id, studentName, studentAge);
  }
}
