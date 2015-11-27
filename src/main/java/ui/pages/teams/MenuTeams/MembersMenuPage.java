package ui.pages.teams.MenuTeams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by MiguelTerceros on 11/24/2015.
 */
public class MembersMenuPage extends BasePageObject {
    @FindBy(xpath = "//a[contains(text(), 'Add Members')]")
    WebElement addMemberBtn;
    /******** ADD elements *********/
    @FindBy(xpath = "//a[contains(text(), 'Add Members')]")
    WebElement addMembersBtn;
    @FindBy(xpath = "//div[@class='search-with-spinner']/input")
    WebElement emailField;

    @FindBy(xpath = "//input[contains(@class,'js-full-name')]")
    WebElement fullNameInvited;

    @FindBy(xpath = "//a[contains(@class,'icon-close' )]")
    WebElement iconClose;
    @FindBy(xpath = "//div[contains(@class,'js-search-results')]/ul/div/li/a")
    WebElement membersOption;
    @FindBy(xpath = "//form[contains(@class,'js-email-data')]/label[contains(text(), 'Full Name')]")
    WebElement fullNameForm;
    @FindBy(xpath = "//form[contains(@class,'js-email-data')]/input[contains(@class,'js-send-email-invite') and contains(@value,'Send')]")
    WebElement sendInvitedBtn;

    By memberInTeam;

    public MembersMenuPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(addMemberBtn));
    }

    /*************** ADD MEMBER **************/
    public MembersMenuPage clickAddMembersBtn(){
        addMembersBtn.click();
        return this;
    }

    public MembersMenuPage setEmailMembers(String email){
        emailField.clear();
        emailField.sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(membersOption));
        return this;
    }

    public MembersMenuPage setEmailInvite(String email){
        emailField.clear();
        emailField.sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(fullNameForm));
        return this;
    }

    public MembersMenuPage setNameInvite(String fullName){
        fullNameInvited.clear();
        fullNameInvited.sendKeys(fullName);
        wait.until(ExpectedConditions.visibilityOf(fullNameForm));
        return this;
    }

    public MembersMenuPage clickMemberOptions(){
        membersOption.click();
        return this;
    }

    public MembersMenuPage clickIconClose(){
        iconClose.click();
        return this;
    }

    public MembersMenuPage clickSendInvitedMember(){
        sendInvitedBtn.click();
        return this;
    }

    public String isNewMemberTeamDisplayed(String fullName){
        return driver.findElement(By.xpath(buildPathMemberTeam(fullName))).getText();
    }

    public String buildPathMemberTeam(String nameMember){
        return "//span[contains(@class, 'full-name') and contains(text(),'"+ nameMember +"')]";
    }

    public MembersMenuPage invitedMemberInTeam(String nameMember, String email){
        clickAddMembersBtn();
        setEmailInvite(email);
        setNameInvite(nameMember);
        clickSendInvitedMember();
        waitUntilPageObjectIsLoaded();
        return this;
    }

    public MembersMenuPage addMemberInTeam(String email){
        clickAddMembersBtn();
        setEmailMembers(email);
        clickMemberOptions();
        clickIconClose();
        waitUntilPageObjectIsLoaded();
        return this;
    }
}
