package com.dasalgadco.testinjava.deterministic.domain;

import com.dasalgadco.testinjava.integration.domain.StudentId;
import com.dasalgadco.testinjava.shared.domain.AggregateRoot;
import java.util.ArrayList;

public class Student extends AggregateRoot {
  private final StudentId id;
  private final StudentShift shift;

  private Student(StudentShift shift) {
    super(new ArrayList<>());
    this.id = new StudentId();
    this.shift = shift;
  }

  public Student(StudentId id, StudentShift shift) {
    super(new ArrayList<>());
    this.id = id;
    this.shift = shift;
  }

  public static Student create(StudentShift shift) {
    Student student = new Student(shift);

    // No domain event is recorded here

    return student;
  }

  public StudentId getId() {
    return id;
  }

  public StudentShift getShift() {
    return shift;
  }

  public boolean isHourBetweenShifts(Integer hour) {
    String hourShift = new TimeShifts().getShift(hour);
    return hourShift.equals(shift.value());
  }
}
