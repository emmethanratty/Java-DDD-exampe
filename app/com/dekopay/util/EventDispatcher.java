package com.dekopay.util;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;

public class EventDispatcher {

    private final EventBus eventBus;

    @Inject
    public EventDispatcher(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void dispatchAll(EventProducer producer) {
        for (var event : producer.drainEvents()) {
            eventBus.post(event);
        }
    }
}
