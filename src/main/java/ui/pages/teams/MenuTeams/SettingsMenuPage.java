package ui.pages.teams.MenuTeams;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.MainPage;

/**
 * Created by MiguelTerceros on 11/24/2015.
 */
public class SettingsMenuPage extends BasePageObject {
    @FindBy(xpath = "//div[contains(@class,'window-module-title')]/h3[contains(text(),'Visibility')]")
    WebElement visibilityLbl;
    /******** DELETE Btn ************/
    @FindBy(xpath = "//a[contains(text(), 'Delete this team?')]")
    WebElement deletedBtn;
    @FindBy(xpath = "//input[@value='Delete Forever']")
    WebElement deletedForeverBtn;

    public SettingsMenuPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(visibilityLbl));
    }

    /**************** DELETE *****************/
    public SettingsMenuPage clickBtnDeleted(){
        deletedBtn.click();
        return this;
    }

    public MainPage clickBtnDeletedForever(){
        deletedForeverBtn.click();
        return new MainPage();
    }

    public MainPage deleteTeam(){
        clickBtnDeleted();
        return clickBtnDeletedForever();
    }
}
