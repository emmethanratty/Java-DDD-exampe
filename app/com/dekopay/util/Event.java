package com.dekopay.util;

import java.time.LocalDateTime;
import java.util.EventObject;

public abstract class Event<Payload> extends EventObject {

   final protected String name;
   protected Payload payload;
   final protected LocalDateTime occurredAt;

    public Event(Object source, String name, Payload payload) {
        super(source);
        this.name = name;
        this.payload = payload;
        this.occurredAt = LocalDateTime.now();
    }

    public Payload payload() {
        return payload;
    }

    public String name() { return name; }

    public LocalDateTime occurredAt() { return occurredAt; }
}
