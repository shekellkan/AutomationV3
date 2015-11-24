package ui.pages.teams;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by MiguelTerceros on 11/24/2015.
 */
public class EditTeamsPage extends BasePageObject {
    @FindBy(xpath = "//div[contains(@class,'tabbed-pane-header-details')]/form/label[contains(text(),'Name')]")
    WebElement nameFormLbl;
    @FindBy(xpath = "//div[contains(@class,'tabbed-pane-header-details')]/form/input[contains(@name,'displayName')]")
    WebElement nameTeamInput;
    @FindBy(xpath = "//div[contains(@class,'tabbed-pane-header-details')]/form/input[contains(@name,'name')]")
    WebElement shortNameTeamInput;
    @FindBy(xpath = "//div[contains(@class,'tabbed-pane-header-details')]/form/input[contains(@name,'website')]")
    WebElement websiteInput;
    @FindBy(xpath = "//div[contains(@class,'tabbed-pane-header-details')]/form/textarea[contains(@name,'desc')]")
    WebElement descriptionTextArea;
    @FindBy(xpath = "//div[contains(@class,'tabbed-pane-header-details')]/form/input[contains(@value,'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//div[contains(@class,'tabbed-pane-header-details')]/form/input[contains(@value,'Cancel')]")
    WebElement cancelBtn;

    public EditTeamsPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameFormLbl));
    }

    public EditTeamsPage setNameTeam(String nameTeam){
        nameTeamInput.clear();
        nameTeamInput.sendKeys(nameTeam);
        return this;
    }

    public EditTeamsPage setShortNameTeam(String shortNameTeam){
        shortNameTeamInput.clear();
        shortNameTeamInput.sendKeys(shortNameTeam);
        return this;
    }

    public EditTeamsPage setWebsite(String website){
        websiteInput.clear();
        websiteInput.sendKeys(website);
        return this;
    }

    public EditTeamsPage setDesciptionTeam(String description){
        descriptionTextArea.clear();
        descriptionTextArea.sendKeys(description);
        return this;
    }

    public TeamsPage clickSaveBtn(){
        saveBtn.click();
        return new TeamsPage();
    }

    public TeamsPage clickCancelBtn(){
        cancelBtn.click();
        return new TeamsPage();
    }

    public TeamsPage changeNameAndWebSite(String newName, String newWebSite){
        setNameTeam(newName);
        setWebsite(newWebSite);
        return clickSaveBtn();
    }

    public TeamsPage changeNameAndDrecription(String newName, String newDescription){
        setNameTeam(newName);
        setDesciptionTeam(newDescription);
        return clickSaveBtn();
    }

    public TeamsPage changeDescriptionAndWebSite(String newDescription, String newwebSite){
        setDesciptionTeam(newDescription);
        setWebsite(newwebSite);
        return clickSaveBtn();
    }

    public TeamsPage changeNameDescriptionWebSite(String newName, String newDescription, String newWebSite){
        setNameTeam(newName);
        setDesciptionTeam(newDescription);
        setWebsite(newWebSite);
        return clickSaveBtn();
    }
}
