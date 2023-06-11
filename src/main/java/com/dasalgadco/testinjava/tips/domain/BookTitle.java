package com.dasalgadco.testinjava.tips.domain;

import com.dasalgadco.testinjava.shared.domain.StringValueObject;
import com.dasalgadco.testinjava.tips.domain.error.InvalidBook;

public class BookTitle extends StringValueObject {
  public BookTitle(String value) {
    super(value);
    if (value.length() <= 0) {
      throw new InvalidBook("The book title can not be empty");
    }
  }
}
