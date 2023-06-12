package com.dasalgadco.testinjava.testdoubles.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dasalgadco.testinjava.acceptance.application.StudentSearcher;
import com.dasalgadco.testinjava.integration.domain.Student;
import com.dasalgadco.testinjava.integration.domain.StudentId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "students.repository=StubStudentRepository")
public class StudentSearcherStubRepositoryTest {
  @Autowired private StudentSearcher studentSearcher;

  @Test
  public void search_should_found_john_doe_with_stub_repository() {
    // Given
    String searchId = "45215570-0296-11ee-8566-acde48001122";

    StudentId studentId = StudentId.create(searchId);
    String studentName = "John Doe";
    Integer studentAge = 20;
    Student expectedStudent = new Student(searchId, studentName, studentAge);

    // When
    Student studentFound = studentSearcher.invoke(searchId);

    // Then
    assertEquals(expectedStudent, studentFound);
  }
}
