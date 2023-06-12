package com.dasalgadco.testinjava.integration.domain;

import com.dasalgadco.testinjava.shared.domain.AggregateRoot;
import java.util.ArrayList;
import java.util.Objects;

public class Student extends AggregateRoot {
  private final StudentId id;
  private final StudentName name;
  private final StudentAge age;

  private Student(String name, Integer age) {
    super(new ArrayList<>());
    this.id = new StudentId();
    this.name = new StudentName(name);
    this.age = new StudentAge(age);
  }

  public Student(String id, String name, Integer age) {
    super(new ArrayList<>());
    this.id = StudentId.create(id);
    this.name = new StudentName(name);
    this.age = new StudentAge(age);
  }

  public static Student create(String name, Integer age) {
    Student student = new Student(name, age);
    student.recordEvent(new StudentCreated(student.id.value()));

    return student;
  }

  public StudentId getId() {
    return id;
  }

  public StudentName getName() {
    return name;
  }

  public StudentAge getAge() {
    return age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Student)) return false;
    Student student = (Student) o;
    return Objects.equals(getId(), student.getId())
        && Objects.equals(getName(), student.getName())
        && Objects.equals(getAge(), student.getAge());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getAge());
  }
}
