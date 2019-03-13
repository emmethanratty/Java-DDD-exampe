package com.dekopay.project.events;

import com.dekopay.util.Event;

public class SpecialistApprovedEvent extends Event {
    private final static String NAME = "specialist-approved";

    public SpecialistApprovedEvent(Object source, SpecialistApprovedPayload specialistDeniedPayload) {
        super(source, NAME, specialistDeniedPayload);
    }
}
