package ui.pages.teams;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.MainPage;
import ui.pages.TopMenuPage;
import ui.pages.teams.MenuTeams.BoardsMenuPage;
import ui.pages.teams.MenuTeams.BusinessClassMenuPage;
import ui.pages.teams.MenuTeams.MembersMenuPage;
import ui.pages.teams.MenuTeams.SettingsMenuPage;

/**
 * Created with IntelliJ IDEA.
 * User: MiguelTerceros
 * Date: 11/17/15
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class TeamsPage extends BasePageObject {
    private TopMenuPage topMenuPage;
    private SettingsMenuPage settingsMenuPage;
    private BoardsMenuPage boardsMenuPage;

    @FindBy(xpath = "//h1[@class='u-inline']")
    WebElement titleTeam;
    /******** MENU Btn *************/
    @FindBy(xpath = "//a[contains(text(),'Settings')]")
    WebElement menuSettings;
    @FindBy(xpath = "//a[contains(text(),'Boards')]")
    WebElement menuBoards;
    @FindBy(xpath = "//a[contains(text(),'Members')]")
    WebElement menuMembers;
    @FindBy(xpath = "//a[contains(text(),'Business Class')]")
    WebElement menuBusiness;

    public TeamsPage(){
        topMenuPage = new TopMenuPage();
        boardsMenuPage = new BoardsMenuPage();
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleTeam));
    }

    public boolean isNameTeamsDisplayed() {
        return titleTeam.isDisplayed();
    }

    public String nameTeam(){
        return titleTeam.getText();
    }

    /******************** MENUS TEAMS ***********************/
    public SettingsMenuPage clickMenuSetting(){
        menuSettings.click();
        return new SettingsMenuPage();
    }

    public BoardsMenuPage clickMenuBoards(){
        if(!boardsMenuPage.isCreateBoardBtnDisplayed()){
            menuBoards.click();
        }
        return new BoardsMenuPage();
    }

    public MembersMenuPage clickMenuMembers(){
        menuMembers.click();
        return new MembersMenuPage();
    }

    public BusinessClassMenuPage clickMenuBusiness(){
        menuBusiness.click();
        return new BusinessClassMenuPage();
    }

    /************ HOME **********/
    public MainPage goToMainPage(){
        return topMenuPage.goToMainPage();
    }

    public MainPage deleteTeam(){
        settingsMenuPage = clickMenuSetting();
        return settingsMenuPage.deleteTeam();
    }
}
