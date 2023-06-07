package com.dasalgadco.testinjava.basics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FizzbuzzTest {
  @Test
  public void TestAllStartsWell() {
    // Given
    // When
    // Then
    assertTrue(true);
  }

  @Test
  public void Test_Any_Number_Should_Return_Self() {
    // Given
    // When
    // Then
    assertEquals("1", Fizzbuzz.evaluate(1));
    assertEquals("2", Fizzbuzz.evaluate(2));
    assertEquals("4", Fizzbuzz.evaluate(4));
  }
}
