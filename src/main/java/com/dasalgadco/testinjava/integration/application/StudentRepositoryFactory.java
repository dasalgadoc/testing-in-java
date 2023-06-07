package com.dasalgadco.testinjava.integration.application;

import com.dasalgadco.testinjava.integration.repository.StudentRepository;
import jakarta.annotation.Resource;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StudentRepositoryFactory {

  @Resource private List<StudentRepository> studentRepositories;

  @Value("${students.repository}")
  private String repositoryName;

  private Optional<StudentRepository> retrieveStudentRepository() {
    return studentRepositories.stream()
        .filter(
            studentRepository ->
                repositoryName.equals(studentRepository.getClass().getSimpleName()))
        .findFirst();
  }

  public StudentRepository getStudentRepository() {
    Optional<StudentRepository> repository = retrieveStudentRepository();
    if (!repository.isPresent()) {
      throw new RuntimeException("Unable to build repository");
    }
    return repository.get();
  }
}
