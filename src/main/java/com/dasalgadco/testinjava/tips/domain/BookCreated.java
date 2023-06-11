package com.dasalgadco.testinjava.tips.domain;

import com.dasalgadco.testinjava.shared.domain.DomainEvent;

public class BookCreated extends DomainEvent {
  private static final String EVENT_NAME = "dasalgadoc.test-in-java.1.book.created";
  private final String ISBN;

  public BookCreated(String ISBN) {
    super(EVENT_NAME);
    this.ISBN = ISBN;
  }

  public String getISBN() {
    return ISBN;
  }
}
