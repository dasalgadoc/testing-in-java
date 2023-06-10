package com.dasalgadco.testinjava.integration.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentCreatorTest {

  @Autowired private StudentCreator studentCreator;

  @Test
  public void testIntegrationWithMYSQLCreateAStudent() {
    // Given
    String studentName = "John Doe";
    Integer studentAge = 20;

    // When
    studentCreator.create(studentName, studentAge);
  }
}
