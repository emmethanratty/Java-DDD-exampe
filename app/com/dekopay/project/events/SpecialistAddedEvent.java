package com.dekopay.project.events;

import com.dekopay.util.Event;

public class SpecialistAddedEvent extends Event {

    private final static String NAME = "specialist-added";

    public SpecialistAddedEvent(Object source, SpecialistAddedPayload specialistAddedPayload) {
        super(source, NAME, specialistAddedPayload);
    }
}
