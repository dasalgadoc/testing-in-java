package com.dasalgadco.testinjava.acceptance.application;

import com.dasalgadco.testinjava.integration.application.StudentRepositoryFactory;
import com.dasalgadco.testinjava.integration.domain.Student;
import com.dasalgadco.testinjava.integration.domain.StudentId;
import com.dasalgadco.testinjava.integration.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StudentSearcher {
  @Resource private StudentRepositoryFactory studentRepositoryFactory;
  private StudentRepository repository;

  @PostConstruct
  public void init() {
    repository = studentRepositoryFactory.getStudentRepository();
  }

  public Student invoke(String id) {
    StudentId studentId = StudentId.create(id);
    return repository.search(studentId);
  }
}
