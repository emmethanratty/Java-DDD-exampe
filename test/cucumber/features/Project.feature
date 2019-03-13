Feature: Creating a Project

    Scenario: Drafting a Project
        Given I am a Research Manager
        When I draft a project with the name of "blah", deadline of "28/04/2020", client of "blah"
        Then I will have a drafted project

    Scenario: Assign a project manager
        Given I am a senior project manager
        And I have a drafted project with the name of "blah", deadline of "28/04/2020", client of "blah"
        When I start a project with a Project Manager "x"
        Then I will have an active project

    Scenario: Adding a pending specialist
        Given I am a project manager
        And I have an active project with the name of "blah", deadline of "28/04/2020", client of "blah"
        When I assign a specialist with an id of "123"
        Then I will have a pending specialist

    Scenario: Approving a specialist
        Given I am a Compliance Officer
        And I have an active project with the name of "blah", deadline of "28/04/2020", client of "blah"
        And a pending specialist with ID "x" is on the project
        When I approve a specialist "x"
        Then specialist "x" will be "APPROVED" for that project

    Scenario: Discarding a specialist
        Given I am a Compliance Officer
        And I have an active project with the name of "blah", deadline of "28/04/2020", client of "blah"
        And a pending specialist with ID "x" is on the project
        When I discard a specialist "x"
        Then specialist "x" will be "DISCARDED" for that project
