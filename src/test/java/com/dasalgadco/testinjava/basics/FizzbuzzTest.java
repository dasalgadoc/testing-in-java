package com.dasalgadco.testinjava.basics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FizzbuzzTest {
  @Test
  public void testAllStartsWell() {
    // Given
    // When
    // Then
    assertTrue(true);
  }

  @Test
  public void test_Any_Number_Should_Return_Self() {
    // Given
    // When
    // Then
    assertEquals("1", Fizzbuzz.evaluate(1));
    assertEquals("2", Fizzbuzz.evaluate(2));
    assertEquals("4", Fizzbuzz.evaluate(4));
  }

  @Test
  public void test_Return_Fizz_If_Divisible_By_3() {
    // Given
    // When
    // Then
    assertEquals("Fizz", Fizzbuzz.evaluate(3));
    assertEquals("Fizz", Fizzbuzz.evaluate(6));
    assertEquals("Fizz", Fizzbuzz.evaluate(9));
  }

  @Test
  public void test_Return_Buzz_If_Divisible_By_5() {
    // Given
    // When
    // Then
    assertEquals("Buzz", Fizzbuzz.evaluate(5));
    assertEquals("Buzz", Fizzbuzz.evaluate(10));
    assertEquals("Buzz", Fizzbuzz.evaluate(20));
  }

  @Test
  public void test_Return_FizzBuzz_If_Divisible_By_3_And_5() {
    // Given
    // When
    // Then
    assertEquals("FizzBuzz", Fizzbuzz.evaluate(15));
    assertEquals("FizzBuzz", Fizzbuzz.evaluate(30));
    assertEquals("FizzBuzz", Fizzbuzz.evaluate(45));
  }
}
