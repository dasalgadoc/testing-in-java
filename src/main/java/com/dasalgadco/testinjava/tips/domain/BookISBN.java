package com.dasalgadco.testinjava.tips.domain;

import com.dasalgadco.testinjava.shared.domain.StringValueObject;
import com.dasalgadco.testinjava.tips.domain.error.InvalidBook;

public class BookISBN extends StringValueObject {
  public BookISBN(String value) {
    super(value);
    validateISBN(value);
  }

  public static void validateISBN(String value) {
    if (value.length() != 13) {
      throw new InvalidBook("The book ISBN must be 13 characters long");
    }
    if (!value.matches("[0-9]+")) {
      throw new InvalidBook("The book ISBN must be a number");
    }
  }
}
