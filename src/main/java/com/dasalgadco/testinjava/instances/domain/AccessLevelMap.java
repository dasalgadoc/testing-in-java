package com.dasalgadco.testinjava.instances.domain;

import java.util.HashMap;
import java.util.Map;

public class AccessLevelMap {
  public Map<String, Integer> value;

  public AccessLevelMap() {
    value = new HashMap<>();
    value.put("USER", 1);
    value.put("AUTHOR", 2);
    value.put("ADMIN", 3);
  }
}
