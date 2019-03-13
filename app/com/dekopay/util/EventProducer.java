package com.dekopay.util;

import java.util.ArrayList;
import java.util.List;

public interface EventProducer {

    List<Object> events = new ArrayList<>();

    default List<Object> drainEvents() {
        var copy = new ArrayList<>(events);
        events.clear();
        return copy;
    }
}
