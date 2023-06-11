package com.dasalgadco.testinjava.tips.domain;

import com.dasalgadco.testinjava.shared.domain.AggregateRoot;
import java.util.ArrayList;
import java.util.Objects;

public class Book extends AggregateRoot {
  private final BookISBN isbn;
  private final BookTitle title;

  public Book(BookISBN isbn, BookTitle title) {
    super(new ArrayList<>());
    this.isbn = isbn;
    this.title = title;
  }

  public static Book create(BookISBN isbn, BookTitle title) {
    Book book = new Book(isbn, title);
    book.recordEvent(new BookCreated(book.isbn.value()));

    return book;
  }

  public BookISBN getIsbn() {
    return isbn;
  }

  public BookTitle getTitle() {
    return title;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Book)) return false;

    Book that = (Book) o;

    return isbn.equals(that.isbn) && title.equals(that.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getIsbn(), getTitle());
  }
}
