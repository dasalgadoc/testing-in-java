package com.dasalgadco.testinjava.integration.application;

import com.dasalgadco.testinjava.integration.domain.Student;
import com.dasalgadco.testinjava.integration.domain.StudentAge;
import com.dasalgadco.testinjava.integration.domain.StudentName;
import com.dasalgadco.testinjava.integration.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StudentCreator {

  @Resource private StudentRepositoryFactory studentRepositoryFactory;
  private StudentRepository repository;

  @PostConstruct
  public void init() {
    repository = studentRepositoryFactory.getStudentRepository();
  }

  public void create(String name, Integer age) {
    Student student = new Student(new StudentName(name), new StudentAge(age));
    repository.save(student);
  }
}
