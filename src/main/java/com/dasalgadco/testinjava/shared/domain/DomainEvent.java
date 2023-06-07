package com.dasalgadco.testinjava.shared.domain;

import java.time.Instant;
import java.util.UUID;

public abstract class DomainEvent {
  protected final String name;
  protected final UUID eventId;
  protected final Instant occurredOn;

  public DomainEvent(String name) {
    this.eventId = UUID.randomUUID();
    this.occurredOn = Instant.now();
    this.name = name;
  }

  public String getDomainEventName() {
    return name;
  }
}
