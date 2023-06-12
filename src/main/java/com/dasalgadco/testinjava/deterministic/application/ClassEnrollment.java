package com.dasalgadco.testinjava.deterministic.application;

import com.dasalgadco.testinjava.deterministic.domain.Student;
import com.dasalgadco.testinjava.shared.domain.OSClock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassEnrollment {
  @Autowired private OSClock clock;

  public void invoke(Student student) {
    Integer hour = clock.getHour();
    if (!student.isHourBetweenShifts(hour)) {
      throw new RuntimeException("student can't take class now");
    }
    System.out.println("student enrolled...");
  }
}
