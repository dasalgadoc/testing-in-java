package com.dasalgadco.testinjava.deterministic.application;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.dasalgadco.testinjava.deterministic.domain.Student;
import com.dasalgadco.testinjava.deterministic.domain.StudentShift;
import com.dasalgadco.testinjava.shared.domain.OSClock;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClassEnrollmentTest {
  @Mock private OSClock clock;

  @InjectMocks private ClassEnrollment classEnrollment;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void morning_student_can_take_class_in_morning() {
    // Given
    StudentShift studentShift = new StudentShift("MORNING");
    Student student = Student.create(studentShift);

    when(clock.getHour()).thenReturn(generateRandomHour(6, 11));

    // When
    classEnrollment.invoke(student);

    // Then
  }

  @Test
  public void morning_student_can_take_class_at_night() {
    // Given
    StudentShift studentShift = new StudentShift("NIGHT");
    Student student = Student.create(studentShift);

    when(clock.getHour()).thenReturn(generateRandomHour(18, 21));

    // When
    assertThrows(RuntimeException.class, () -> classEnrollment.invoke(student));

    // Then
  }

  public Integer generateRandomHour(Integer min, Integer max) {
    return (int) (Math.random() * (max - min + 1) + min);
  }
}
