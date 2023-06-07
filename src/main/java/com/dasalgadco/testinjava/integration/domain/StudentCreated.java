package com.dasalgadco.testinjava.integration.domain;

import com.dasalgadco.testinjava.shared.domain.DomainEvent;
import java.util.Objects;

public class StudentCreated extends DomainEvent {
  private static final String EVENT_NAME = "dasalgadoc.test-in-java.1.student.created";
  private final String id;

  public StudentCreated(String id) {
    super(EVENT_NAME);
    this.id = id;
  }

  public String getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    StudentCreated that = (StudentCreated) o;

    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }
}
