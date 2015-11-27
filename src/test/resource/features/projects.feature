@Projects
Feature: Projects
  create new projects, add members, change background, delete project

    Background:
      Given I navigate to login page of Trello.com
        And I login in Trello.com as "miguel.terceros@fundacion-jala.org" with password "morfeo3730"

  Scenario: Add a new project
    Given I go to create Project page
    When I add a new project "New_Project"
      Then the new project "New_Project" is created

  Scenario: Add a new project with team
    Given I go to create Project page  with a team
      And I create a team "Project_Team" with description "this team pertenece a project"
      Then I navigate to main page
    When I add a new project "Project_With_Team" by selecting the team "Project_Team"
      Then the new project "Project_With_Team" is created with the team "Project_Team"

#  Scenario: Invited a new member a project
#    Given I go to create Project page "Project_Invited_Member"
#      And I navigate to menu add member
#    When I invited a "Mike Power" with the email "mike03730@gmail.com"
#      And I added a "Jorge Avila" with the email "jorge.avila@fundacion-jala.org"
#      Then The member "Mike Power" is added to project
#      And The member "Jorge Avila" is added to project

#  Scenario: Deleted a project
#    Given I create a project "Project_Deleted"
#    And I deleted the project
#    Then the project "Project_Deleted" is deleted