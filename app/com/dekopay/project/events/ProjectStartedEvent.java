package com.dekopay.project.events;


import com.dekopay.util.Event;

public class ProjectStartedEvent extends Event {
    private static final String NAME = "project-started";

    public ProjectStartedEvent(Object source, ProjectStartedPayload projectStartedPayload) {
        super(source, NAME, projectStartedPayload);
    }
}
