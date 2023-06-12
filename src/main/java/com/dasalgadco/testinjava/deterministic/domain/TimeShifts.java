package com.dasalgadco.testinjava.deterministic.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeShifts {
  private Map<String, List<Integer>> value;

  public TimeShifts() {
    value = new HashMap<>();
    value.put("MORNING", List.of(6, 11));
    value.put("AFTERNOON", List.of(6, 11));
    value.put("NIGHT", List.of(6, 11));
  }

  public boolean isShiftRegistered(String shift) {
    return value.containsKey(shift);
  }

  public String getShift(Integer hour) {
    for (Map.Entry<String, List<Integer>> entry : value.entrySet()) {
      if (hour >= entry.getValue().get(0) && hour <= entry.getValue().get(1)) {
        return entry.getKey();
      }
    }
    return "";
  }
}
