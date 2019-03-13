package com.dekopay.project.events;

import com.dekopay.util.Event;

public class ProjectDraftedEvent extends Event {

    private final static String NAME = "project-drafted";

    public ProjectDraftedEvent(Object source,  ProjectDraftedPayload projectDraftedPayload) {
        super(source, NAME, projectDraftedPayload);
    }
}
