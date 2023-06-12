package com.dasalgadco.testinjava.shared.domain;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

@Service
public class OSClock {
  public Integer getHour() {
    LocalTime time = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");
    return Integer.parseInt(time.format(formatter));
  }
}
