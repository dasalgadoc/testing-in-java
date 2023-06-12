package com.dasalgadco.testinjava.testdoubles.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dasalgadco.testinjava.acceptance.application.StudentSearcher;
import com.dasalgadco.testinjava.integration.domain.Student;
import com.dasalgadco.testinjava.testdoubles.infrastructure.database.InMemoryStudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "students.repository=InMemoryStudentRepository")
public class StudentSearcherFakeRepositoryTest {

  @Autowired private StudentSearcher studentSearcher;

  @Autowired private InMemoryStudentRepository inMemoryStudentRepository;

  @Test
  public void search_should_found_an_existing_student_with_fake_repository() {
    // Given
    String searchId = "45215570-0296-11ee-8566-acde48001122";
    String studentName = "John Doe";
    Integer studentAge = 20;

    Student expectedStudent = new Student(searchId, studentName, studentAge);
    inMemoryStudentRepository.save(expectedStudent);

    // When
    Student studentFound = studentSearcher.invoke(searchId);

    // Then
    assertEquals(expectedStudent, studentFound);
  }
}
