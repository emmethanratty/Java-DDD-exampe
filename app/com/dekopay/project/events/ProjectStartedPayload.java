package com.dekopay.project.events;

import com.dekopay.project.Reference;

import java.util.Date;

public class ProjectStartedPayload {


    private final String projectManagerId;
    private final Reference reference;

    public String getProjectManagerId() {
        return projectManagerId;
    }

    public Reference getReference() {
        return reference;
    }

    public String getName() {
        return name;
    }

    public String getClientId() {
        return clientId;
    }

    public Date getDeadline() {
        return deadline;
    }

    private final String name;
    private final String clientId;
    private final Date deadline;

    public ProjectStartedPayload(
            String projectManagerId,
            Reference reference,
            String name,
            String clientId,
            Date deadline
    ) {
        this.projectManagerId = projectManagerId;
        this.reference = reference;
        this.name = name;
        this.clientId = clientId;
        this.deadline = deadline;
    }
}
