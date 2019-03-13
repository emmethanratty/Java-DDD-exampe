package com.dekopay.project;

import com.dekopay.project.events.*;
import com.dekopay.util.EventProducer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Project implements EventProducer {

    private final Date deadline;
    private final String name;
    private final String clientId;
    private String projectManagerId;
    private final Reference reference = new Reference();
    private ProjectState state = ProjectState.DRAFT;

    private final Map<String, SpecialistType> specialists = new HashMap<>();

    private Project(Date deadline, String name, String clientId) {
        if(!isDeadlineInTheFuture(deadline)) {
            throw new RuntimeException("Project deadline should be in the future");
        }

        this.deadline = deadline;
        this.name = name;
        this.clientId = clientId;

        events.add(
            new ProjectDraftedEvent(
                this,
                new ProjectDraftedPayload(name, reference, deadline, clientId)
            )
        );
    }

    public static Project draft(Date deadline, String name, String clientId){
        return new Project(deadline, name, clientId);
    }

    public Reference start(String projectManagerId){
        if(!state.equals(ProjectState.DRAFT)) {
            throw new RuntimeException("Project is not in a drafted state");
        }

        this.projectManagerId = projectManagerId;
        this.state = ProjectState.ACTIVE;

        events.add(new ProjectStartedEvent(
                this,
                new ProjectStartedPayload(projectManagerId, reference, name, clientId, deadline)
            )
        );

        return reference;
    }

    public Reference addSpecialist(String specialistId) {

        if(!state.equals(ProjectState.ACTIVE)) {
            throw new RuntimeException("Project is not in an active state");
        }

        if(specialists.containsKey(specialistId)){
            throw new RuntimeException("Specialist has already been added to the project");
        }

        specialists.put(specialistId, SpecialistType.PENDING);

        events.add(
            new SpecialistAddedEvent(
                this,
                new SpecialistAddedPayload(name, reference, specialistId)
            )
        );

        return reference;
    }

    public Reference approveSpecialist(String specialistId) {

        if(!state.equals(ProjectState.ACTIVE)){
            throw new RuntimeException("Project is not in an active state");
        }

        var specialistStatus = specialists.get(specialistId);

        if (specialistStatus == SpecialistType.APPROVED || specialistStatus == SpecialistType.DISCARDED){
            throw new RuntimeException("Specialist has already been added approved or denied");
        }

        specialists.put(specialistId, SpecialistType.APPROVED);

        events.add(
            new SpecialistApprovedEvent(
                this,
                new SpecialistApprovedPayload()
            )
        );

        return reference;
    }

    public Reference discardSpecialist(String specialistId) {

        if(!state.equals(ProjectState.ACTIVE)){
            throw new RuntimeException("Project is not in an active state");
        }

        var specialistStatus = specialists.get(specialistId);

        if (specialistStatus == SpecialistType.APPROVED || specialistStatus == SpecialistType.DISCARDED){
            throw new RuntimeException("Specialist has already been added approved or denied");
        }

        specialists.put(specialistId, SpecialistType.DISCARDED);

        events.add(
            new SpecialistApprovedEvent(
                this,
                new SpecialistApprovedPayload()
            )
        );

        return reference;
    }

    private boolean isDeadlineInTheFuture(Date deadline) {
        return deadline.after(new Date());
    }

    public Date getDeadline() { return deadline; }

    public String getName() { return name; }

    public String getClientId() { return clientId; }

    public String getProjectManagerId() { return projectManagerId; }

    public Reference getReference() { return reference; }

    public ProjectState getState() { return state; }

    public Map<String, SpecialistType> getSpecialists() { return specialists; }

}
