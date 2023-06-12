package com.dasalgadco.testinjava.tips.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.Random.class)
public class BookTest {
  @Test
  public void testAssertionEquals() {
    // Given
    String bookISBN = "9780544003415";
    String bookTitle = "The Lord of the Rings";

    Book one = new Book(bookISBN, bookTitle);
    Book two = new Book(bookISBN, bookTitle);

    // When
    // Then: equals() is overridden in Book class
    assertEquals(one, two);
    assertNotSame(one, two);
  }

  @Test
  public void testAssertionWithReferences() {
    // Given
    String bookISBN = "9780544003415";
    String bookTitle = "The Lord of the Rings";

    Book one = new Book(bookISBN, bookTitle);
    Book two = one;

    // When
    // Then
    assertEquals(one, two);
    assertSame(one, two);
  }
}
