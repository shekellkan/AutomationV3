package ui.pages.teams.MenuTeams;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.AddBoardPage;

/**
 * Created by MiguelTerceros on 11/24/2015.
 */
public class BoardsMenuPage extends BasePageObject {
    @FindBy(xpath = "//a[contains(@class,'board-tile')]/span[contains(text(),'Create new board…')]")
    WebElement createBoardBtn;

    public BoardsMenuPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(createBoardBtn));
    }

    public AddBoardPage clickCreateNewBoard(){
        createBoardBtn.click();
        return new AddBoardPage();
    }
}
