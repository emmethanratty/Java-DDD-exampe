package com.dekopay.project.events;

import com.dekopay.project.Reference;

public class SpecialistAddedPayload {
    private final String name;

    public String getName() {
        return name;
    }

    public Reference getReference() {
        return reference;
    }

    public String getSpecialistId() {
        return specialistId;
    }

    private final Reference reference;
    private final String specialistId;

    public SpecialistAddedPayload(String name, Reference reference, String specialistId) {

        this.name = name;
        this.reference = reference;
        this.specialistId = specialistId;
    }
}
