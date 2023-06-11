package com.dasalgadco.testinjava.testdoubles.application;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.dasalgadco.testinjava.acceptance.application.StudentSearcher;
import com.dasalgadco.testinjava.integration.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "students.repository=DummyStudentRepository")
public class StudentSearcherDummyRepository {
  @Autowired private StudentSearcher studentSearcher;

  @Test
  public void search_should_found_an_existing_student_with_dummy_repository() {
    // Given
    String searchId = "45215570-0296-11ee-8566-acde48001122";

    // When
    Student foundStudent = studentSearcher.invoke(searchId);

    // Then
    assertNull(foundStudent);
  }
}
