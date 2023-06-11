package com.dasalgadco.testinjava.testdoubles.application;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.dasalgadco.testinjava.acceptance.application.StudentSearcher;
import com.dasalgadco.testinjava.integration.domain.Student;
import com.dasalgadco.testinjava.integration.domain.StudentAge;
import com.dasalgadco.testinjava.integration.domain.StudentId;
import com.dasalgadco.testinjava.integration.domain.StudentName;
import com.dasalgadco.testinjava.integration.repository.StudentRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentSearcherMockRepository {
  @Mock private StudentRepository studentRepository;

  @InjectMocks private StudentSearcher studentSearcher;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void search_should_found_an_existing_student_with_mock_repository() {
    // Given
    String searchId = "45215570-0296-11ee-8566-acde48001122";

    StudentId studentId = StudentId.create(searchId);
    StudentName studentName = new StudentName("John Doe");
    StudentAge studentAge = new StudentAge(20);
    Student expectedStudent = new Student(studentId, studentName, studentAge);

    when(studentRepository.search(studentId)).thenReturn(expectedStudent);

    // When
    Student studentFound = studentSearcher.invoke(searchId);

    // Then
    assertEquals(expectedStudent, studentFound);
  }
}
