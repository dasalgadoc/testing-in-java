package com.dasalgadco.testinjava.testdoubles.application;

import com.dasalgadco.testinjava.integration.application.StudentRepositoryFactory;
import com.dasalgadco.testinjava.integration.domain.Student;
import com.dasalgadco.testinjava.integration.domain.StudentId;
import com.dasalgadco.testinjava.integration.repository.StudentRepository;
import com.dasalgadco.testinjava.testdoubles.application.error.StudentSignUpException;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StudentSignUp {
  @Resource private StudentRepositoryFactory studentRepositoryFactory;
  private StudentRepository repository;

  @PostConstruct
  public void init() {
    repository = studentRepositoryFactory.getStudentRepository();
  }

  public void invoke(String name, Integer age) {
    StudentId studentId = new StudentId();
    try {
      repository.search(studentId);
      throw new StudentSignUpException("Student already exists");
    } catch (Exception e) {
      Student student = new Student(studentId.value(), name, age);
      repository.save(student);
    }
  }
}
