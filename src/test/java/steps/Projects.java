package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import ui.pages.*;
import ui.pages.projects.AddProjectPage;
import ui.pages.projects.CloseProjectPage;
import ui.pages.projects.ProjectsPage;
import ui.pages.teams.AddTeamPage;
import ui.pages.teams.TeamsPage;

/**
 * Created by amateur on 15/11/2015.
 */
public class Projects {
    private MainPage mainPage = new MainPage();
    private AddTeamPage addTeam;
    private TeamsPage teamPage;
    private TopMenuPage topMenu;
    private ProjectsPage projectPage;
    private CloseProjectPage closeProject;
    private AddProjectPage addProject;

    @Given("^I go to create Project page$")
    public void Create_A_New_Project(){
        addProject = mainPage.clickNewProject();
    }

    @And("^I add a new project \"([^\"]*)\"$")
    public void Add_A_New_Project(String title){
        projectPage = addProject.createNewProjects(title);
    }

    @Then("^the new project \"([^\"]*)\" is created$")
    public void theNewProjectIsCreated(String title){
        assertTrue(projectPage.isNameProjectDisplayed());
        assertEquals(title, projectPage.titleProject().getText());
    }

    @Given("^I go to create Project page  with a \"([^\"]*)\" team$")
    public void createProjectWithTeam(String nameTeam){
        addTeam = mainPage.clickNewTeam();
        teamPage = addTeam.createTeam(nameTeam);
        mainPage = teamPage.goToMainPage();
    }

    @And("^I add a new project \"([^\"]*)\" by selecting the team \"([^\"]*)\"$")
    public void iAddANewProjectBySelectingTheTeam(String nameProject, String nameTeam){
        addProject = mainPage.clickNewProject();
        projectPage = addProject.createNewProjectWithTeam(nameTeam, nameProject);
    }

    @Given("^I create a project \"([^\"]*)\"$")
    public void iCreateAProject(String nameProject){
        addProject = mainPage.clickNewProject();
        projectPage = addProject.createNewProjects(nameProject);
    }

    @And("^I deleted the project$")
    public void deletedProject(){
        closeProject = projectPage.deleteProject();
    }

    @Then("^the project \"([^\"]*)\" is deleted$")
    public void theProjectIsDeleted(String nameProjectDeleted){
        assertTrue(closeProject.isCloseProject());
        //Assert.assertFalse(mainPage.isProjectPresent(nameProjectDeleted));
    }

    /**************** AFTER ********************/
    @After(value = "@Projects", order = 999)
    public void afterTeamScenario() {
        topMenu = new TopMenuPage();
        topMenu.logout();
        //DriverManager.getInstance().quitDriver();
    }
}