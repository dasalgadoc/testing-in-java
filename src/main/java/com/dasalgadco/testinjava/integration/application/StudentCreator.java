package com.dasalgadco.testinjava.integration.application;

import com.dasalgadco.testinjava.integration.domain.Student;
import com.dasalgadco.testinjava.integration.domain.StudentAge;
import com.dasalgadco.testinjava.integration.domain.StudentName;
import com.dasalgadco.testinjava.integration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentCreator {
  @Autowired
  @Qualifier("MySQLStudentRepository")
  private StudentRepository repository;

  public void create(String name, Integer age) {
    Student student = new Student(new StudentName(name), new StudentAge(age));
    repository.save(student);
  }
}
