package com.dasalgadco.testinjava.testdoubles.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.dasalgadco.testinjava.integration.domain.StudentId;
import com.dasalgadco.testinjava.integration.repository.StudentRepository;
import com.dasalgadco.testinjava.testdoubles.infrastructure.database.VanillaSpyStudentRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestPropertySource(properties = "students.repository=VanillaSpyStudentRepository")
public class StudentSignUpTest {
  @Autowired private VanillaSpyStudentRepository vanillaSpyStudentRepository;
  @Autowired private StudentSignUp studentSignUp;

  @Mock private StudentRepository studentRepository;

  @InjectMocks private StudentSignUp studentSignUpMock;

  @Before
  public void setup() {
    vanillaSpyStudentRepository.reset();
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void student_sign_up_should_call_search_and_save_method() {
    // Given
    String studentName = "John Doe";
    Integer studentAge = 20;

    // When
    studentSignUp.invoke(studentName, studentAge);

    // Then
    assertTrue(vanillaSpyStudentRepository.isSaveWasCalled());
    assertTrue(vanillaSpyStudentRepository.isSearchWasCalled());

    assertEquals(1, vanillaSpyStudentRepository.getSaveCalls());
    assertEquals(1, vanillaSpyStudentRepository.getSearchCalls());
  }

  @Test
  public void student_sign_up_should_call_search_and_save_method_mock() {
    // Given
    String studentName = "John Doe";
    Integer studentAge = 20;

    when(studentRepository.search(any(StudentId.class)))
        .thenThrow(new RuntimeException("Student not found"));

    // When
    studentSignUpMock.invoke(studentName, studentAge);

    // Then
    Mockito.verify(studentRepository, Mockito.times(1)).search(any(StudentId.class));
    Mockito.verify(studentRepository, Mockito.times(1)).save(any());
  }
}
