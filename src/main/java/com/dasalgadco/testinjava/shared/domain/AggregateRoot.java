package com.dasalgadco.testinjava.shared.domain;

import java.util.ArrayList;
import java.util.List;

public class AggregateRoot {
  private List<DomainEvent> eventList;

  public AggregateRoot(List<DomainEvent> eventList) {
    this.eventList = eventList;
  }

  public List<DomainEvent> pullDomainEvents() {
    List<DomainEvent> events = new ArrayList<>(eventList);
    eventList.clear();

    return events;
  }

  protected void recordEvent(DomainEvent domainEvent) {
    eventList.add(domainEvent);
  }
}
