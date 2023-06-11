package com.dasalgadco.testinjava.testdoubles.infrastructure.database;

import com.dasalgadco.testinjava.integration.domain.Student;
import com.dasalgadco.testinjava.integration.domain.StudentId;
import com.dasalgadco.testinjava.integration.repository.StudentRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component("InMemoryStudentRepository")
public class InMemoryStudentRepository implements StudentRepository {

  private Map<StudentId, Student> students;

  public InMemoryStudentRepository() {
    this.students = new HashMap<>();
  }

  @Override
  public void save(Student student) {
    students.put(student.getId(), student);
  }

  @Override
  public Student search(StudentId id) {
    Student student = students.get(id);
    if (student == null) {
      throw new RuntimeException("Student not found");
    }

    return student;
  }
}
