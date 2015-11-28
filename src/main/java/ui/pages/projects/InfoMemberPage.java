package ui.pages.projects;

import org.apache.velocity.runtime.directive.Scope;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by MiguelTerceros on 11/27/2015.
 */
public class InfoMemberPage extends BasePageObject {
    @FindBy(xpath = "//h3[contains(@class,'mini-profile-info-title')]/a[contains(@class,'mini-profile-info-title-link')]")
    WebElement titleProfile;

    public InfoMemberPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleProfile));
    }

    public boolean isTitleProfilePresent(){
        return titleProfile.isDisplayed();
    }

    public String getTextTitleProfile(){
        return titleProfile.getText();
    }
}
