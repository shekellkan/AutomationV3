package ui.pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.projects.ProjectsPage;
import ui.pages.projects.CloseProjectPage;
import ui.pages.teams.MenuTeams.MembersMenuPage;

/**
 * Created by amateur on 15/11/2015.
 */
public class ProjectMenuPage extends BasePageObject {

    @FindBy(xpath = "//h3[contains(text(),'Menu')]")
    WebElement title;
    /********* MORE MENU *********/
    @FindBy(xpath = "//li/a[@class='board-menu-navigation-item-link js-open-more' and contains(text(),'More')]")
    WebElement ItemMenuMore;
    @FindBy(xpath = "//h3[contains(@class,'js-board-menu-title-text') and contains(text(),'More')]")
    WebElement menuMore;
    @FindBy(xpath = "//a[contains(@class,'js-close-board') and contains(text(),'Close Board…')]")
    WebElement closeBoard;
    @FindBy(xpath = "//span[contains(@class,'js-fill-pop-over-title') and contains(text(),'Close Board?')]")
    WebElement confirmCloseBoard;
    @FindBy(xpath = "//input[contains(@class,'js-confirm') and contains(@value,'Close')]")
    WebElement closeBtn;
    /*********** ADD MEMBER MENU ***********/
    @FindBy(xpath = "//a[contains(@class,'button-link') and contains(text(),'Add Members…')]")
    WebElement addMemberMenu;
    @FindBy(xpath = "//div[contains(@class,'pop-over-header')]/span[contains(@class, 'js-fill-pop-over-title') and contains(text(),'Members')]")
    WebElement membersFormLbl;
    @FindBy(xpath = "//h3[contains(@class,'mini-profile-info-title')]/a[contains(@class,'mini-profile-info-title-link')]")
    WebElement titleProfile;
    /********* INFO MEMBER ************/
    WebElement infoMemberBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    public ProjectMenuPage clickMenuMore(){
        ItemMenuMore.click();
        wait.until(ExpectedConditions.visibilityOf(menuMore));
        return this;
    }

    public ProjectMenuPage clickCloseBoard(){
        closeBoard.click();
        wait.until(ExpectedConditions.visibilityOf(confirmCloseBoard));
        return this;
    }

    public CloseProjectPage clickConfirmCloseBoard(){
        closeBtn.click();
        return new CloseProjectPage();
    }

    public CloseProjectPage closeProject() {
        clickMenuMore();
        clickCloseBoard();
        return clickConfirmCloseBoard();
    }

    public MembersMenuPage clickAddMember() {
        addMemberMenu.click();
        wait.until(ExpectedConditions.visibilityOf(membersFormLbl));
        return new MembersMenuPage();
    }

    public String buildPathInfoMember(String nameMember){
        return "//div[contains(@class,'js-list-board-members')]/div[contains(@class,'member')]/span[contains(@class,'member-initials') and contains(@title, '"+nameMember+"')]";
    }

    public InfoMemberPage clickInfoMember(String nameMember){
        infoMemberBtn = driver.findElement(By.xpath(buildPathInfoMember(nameMember)));
        infoMemberBtn.click();
        waitUntilPageObjectIsLoaded();
        return new InfoMemberPage();
    }
}
