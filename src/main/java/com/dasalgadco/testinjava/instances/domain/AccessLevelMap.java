package com.dasalgadco.testinjava.instances.domain;

import java.util.HashMap;
import java.util.Map;

public class AccessLevelMap {
  public Map<String, Integer> accessLevelMap;

  public AccessLevelMap() {
    accessLevelMap = new HashMap<>();
    accessLevelMap.put("USER", 1);
    accessLevelMap.put("AUTHOR", 2);
    accessLevelMap.put("ADMIN", 3);
  }
}
