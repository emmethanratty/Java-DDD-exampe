package com.dekopay.project.events;

import com.dekopay.util.Event;

public class SpecialistDeniedEvent extends Event {
    private final static String NAME = "specialist-denied";

    public SpecialistDeniedEvent(Object source, SpecialistDeniedPayload specialistDeniedPayload) {
        super(source, NAME, specialistDeniedPayload);
    }
}
