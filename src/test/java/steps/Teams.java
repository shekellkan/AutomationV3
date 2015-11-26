package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import ui.pages.MainPage;
import ui.pages.projects.AddProjectPage;
import ui.pages.projects.ProjectsPage;
import ui.pages.teams.MenuTeams.BoardsMenuPage;
import ui.pages.teams.MenuTeams.MembersMenuPage;
import ui.pages.teams.TeamsPage;
import ui.pages.TopMenuPage;
import ui.pages.teams.AddTeamPage;

/**
 * Created with IntelliJ IDEA.
 * User: MiguelTerceros
 * Date: 11/17/15
 * Time: 12:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Teams {
    private TopMenuPage topMenu;
    private MainPage mainPage = new MainPage();
    private TeamsPage teamPage;
    private AddTeamPage addNewTeam;
    private MembersMenuPage membersMenuPage;
    private BoardsMenuPage boardsMenuPage;
    private AddProjectPage addProjectPage;
    private ProjectsPage projectsPage;
    public String newMember;

    /*********** CREATE TEAM ************/
    @Given("^I go to Create Team page$")
    public void new_Team(){
        addNewTeam = mainPage.clickNewTeam();
    }

    @And("^I have to create a new team \"([^\"]*)\" with description \"([^\"]*)\"$")
    public void create_Teams_Description(String nameTeam, String description){
        teamPage = addNewTeam.createNewTeams(nameTeam, description);
    }

    @Then("^The new team \"([^\"]*)\" is created.$")
    public void new_Team_Created(String name){
        assertTrue(teamPage.isNameTeamsDisplayed());
        assertEquals(name, teamPage.nameTeam());
    }

    /**************** DELETE *************/
    @Given("^I create a team \"([^\"]*)\" with description \"([^\"]*)\"$")
    public void deleted_a_team(String nameTeam, String description){
        addNewTeam = mainPage.clickNewTeam();
        teamPage = addNewTeam.createNewTeams(nameTeam, description);
    }

    @And("^I deleted the team$")
    public void deleted_Teams(){
        mainPage = teamPage.deleteTeam();
    }

    @Then("^The team \"([^\"]*)\" is deleted$")
    public void teams_is_deleted(String teamDeleted){
        assertFalse(mainPage.isTeamPresent(teamDeleted));
    }

    /**************** ADD MEMBERS ****************/
    @Given("^I add new members in team \"([^\"]*)\" with description \"([^\"]*)\"$")
    public void new_members_team(String nameTeam, String description){
        addNewTeam = mainPage.clickNewTeam();
        teamPage = addNewTeam.createNewTeams(nameTeam, description);
    }

    @And("^I navigate until to menu Members$")
    public void navigate_menu_members(){
        membersMenuPage = teamPage.clickMenuMembers();
    }

    @And("^I add to member \"([^\"]*)\" with the email \"([^\"]*)\"$")
    public void add_new_member(String nameMember, String email){
        membersMenuPage.addMemberInTeam(nameMember, email);
        newMember = membersMenuPage.isNewMemberTeamDisplayed(nameMember);
    }

    @Then("^The  member \"([^\"]*)\" is added in the team$")
    public void new_member_is_added(String nameMember){
        assertEquals(nameMember, newMember);
    }

    @Given("^I navigate to team page \"([^\"]*)\"$")
    public void navigate_to_teamPage(String nameTeam){
        addNewTeam = mainPage.clickNewTeam();
        teamPage = addNewTeam.createTeam(nameTeam);
    }

    @And("^I navigate to projects menu in team$")
    public void navigate_to_boardPage(){
        boardsMenuPage =  teamPage.clickMenuBoards();
    }

    @And("^I create a project \"([^\"]*)\" for the team$")
    public void create_project_team(String nameProject){
        addProjectPage = boardsMenuPage.clickCreateNewBoard();
        projectsPage = addProjectPage.createNewProjects(nameProject);
    }

    @Then("^The project \"([^\"]*)\" is added in the team \"([^\"]*)\"$")
    public void project_in_team(String nameProject, String nameTeam){
        assertEquals(nameProject, projectsPage.nameOfProject());
        assertEquals(nameTeam, projectsPage.nameOfTeamInProject());
    }

//    /**************** AFTER ********************/
//    @After(value = "@Teams", order = 999)
//    public void afterTeamScenario() {
//        topMenu = new TopMenuPage();
//        topMenu.logout();
//    }
}
