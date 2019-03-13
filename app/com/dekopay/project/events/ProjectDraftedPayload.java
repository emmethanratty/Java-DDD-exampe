package com.dekopay.project.events;

import com.dekopay.project.Reference;

import java.util.Date;

public class ProjectDraftedPayload {

    private final String name;
    private final Reference reference;
    private final Date deadline;
    private final String clientId;

    public ProjectDraftedPayload(String name, Reference reference, Date deadline, String clientId) {
        this.name = name;
        this.reference = reference;
        this.deadline = deadline;
        this.clientId = clientId;
    }

    public String getName() { return name; }

    public Reference getReference() { return reference; }

    public Date getDeadline() { return deadline; }

    public String getClientId() { return clientId; }
}
