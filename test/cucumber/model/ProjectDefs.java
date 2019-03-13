package cucumber.model;

import com.dekopay.project.Project;
import com.dekopay.project.SpecialistType;
import com.dekopay.project.events.ProjectDraftedEvent;
import com.dekopay.project.events.ProjectStartedEvent;
import com.dekopay.project.events.SpecialistAddedEvent;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProjectDefs {

    private Project project;

    @Given("^I am a Research Manager")
    public void iAmAResearchManager() {}

    @Given("^I am a senior project manager")
    public void iAmASeniorProjectManager() {}

    @Given("^I am a project manager")
    public void iAmAProjectManager() {}

    @Given("^I am a Compliance Officer")
    public void iAmAComplianceOfficer() {}

    @Given("^a pending specialist with ID \"([^\"]*)\" is on the project")
    public void aPendingSpecialistIsOnTheProject(String specialistId) {
        project.addSpecialist(specialistId);
    }

    @Given("^I have an active project with the name of \"([^\"]*)\", deadline of \"([^\"]*)\", client of \"([^\"]*)\"")
    public void iHaveAnActiveProject(String name, String deadline, String client) throws ParseException {
        project = Project.draft(new SimpleDateFormat("dd/MM/yyyy").parse(deadline), name, client);
        project.start("1");
    }

    @Given("^I have a drafted project with the name of \"([^\"]*)\", deadline of \"([^\"]*)\", client of \"([^\"]*)\"")
    public void iHaveADraftedProject(String name, String deadline, String client) throws ParseException {
        project = Project.draft(new SimpleDateFormat("dd/MM/yyyy").parse(deadline), name, client);
    }

    @When("^I draft a project with the name of \"([^\"]*)\", deadline of \"([^\"]*)\", client of \"([^\"]*)\"")
    public void iDraftAProject(String name, String deadline, String client) throws ParseException {
        project = Project.draft(new SimpleDateFormat("dd/MM/yyyy").parse(deadline), name, client);
    }

    @When("^I start a project with a Project Manager \"([^\"]*)\"")
    public void iDraftAProject(String projectManager) {
        project.start(projectManager);
    }

    @When("^I approve a specialist \"([^\"]*)\"")
    public void iApproveASpecialist(String specialistId) {
        project.approveSpecialist(specialistId);
    }

    @When("^I discard a specialist \"([^\"]*)\"")
    public void iDiscardASpecialist(String specialistId) {
        project.discardSpecialist(specialistId);
    }

    @When("^I assign a specialist with an id of \"([^\"]*)\"")
    public void iAssignASpecialist(String specialtistId) {
        project.addSpecialist(specialtistId);
    }

    @Then("I will have a drafted project")
    public void iWillHaveADraftedProject() {
        var events = project.drainEvents();

        if(events.stream().noneMatch(e -> e instanceof ProjectDraftedEvent)){
            throw new RuntimeException("No drafted projects");
        }
    }

    @Then("I will have a pending specialist")
    public void iWillHaveAPendingSpecialist() {
        var specialists = project.getSpecialists();
        var events = project.drainEvents();

        if(!specialists.containsValue(SpecialistType.PENDING)){
            throw new RuntimeException("Does not contain a pending specialist");
        }
        if(events.stream().noneMatch(e -> e instanceof SpecialistAddedEvent)){
            throw new RuntimeException("No drafted projects");
        }
    }

    @Then("I will have an active project")
    public void iWillHaveAnActiveProject() {
        var events = project.drainEvents();

        if(events.stream().noneMatch(e -> e instanceof ProjectStartedEvent)){
            throw new RuntimeException("No started projects");
        }
    }

    @Then("specialist \"([^\"]*)\" will be \"([^\"]*)\" for that project")
    public void specialistWillBe(String specialistId, String status) {
        var specialists = project.getSpecialists();

        if(specialists.get(specialistId) != SpecialistType.valueOf(status)) {
            throw new RuntimeException("not right");
        }
    }
}
