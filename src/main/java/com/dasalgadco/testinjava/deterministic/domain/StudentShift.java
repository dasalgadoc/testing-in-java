package com.dasalgadco.testinjava.deterministic.domain;

import com.dasalgadco.testinjava.shared.domain.StringValueObject;

public class StudentShift extends StringValueObject {
  public StudentShift(String value) {
    super(value);
    TimeShifts timeShifts = new TimeShifts();
    if (!timeShifts.isShiftRegistered(value)) {
      throw new RuntimeException("Shift not found");
    }
  }

  public StudentShift(Integer hour) {
    super(new TimeShifts().getShift(hour));
  }
}
