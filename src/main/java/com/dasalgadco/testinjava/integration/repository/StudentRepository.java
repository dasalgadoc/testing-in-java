package com.dasalgadco.testinjava.integration.repository;

import com.dasalgadco.testinjava.integration.domain.Student;
import com.dasalgadco.testinjava.integration.domain.StudentId;

public interface StudentRepository {
  void save(Student student);

  Student search(StudentId id);
}
