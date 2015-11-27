package common;

import framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: MiguelTerceros
 * Date: 11/17/15
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Utils {
    public static WebElement memberFound;
    public static WebDriver driver = DriverManager.getInstance().getWebDriver();
    private static Logger log = Logger.getLogger("RunCukesTest");

    public static boolean isElementPresent(By byElement) {
        try {
            System.out.println("++++++++++++++++++++++++++++ aqui entre encontre 1 ++++++++++++++++");
            driver.findElement(byElement);
            System.out.println("++++++++++++++++++++++++++++ aqui entre encontre 2 ++++++++++++++++");
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("############################ aqui entre no encontre ^######333");
            return false;
        }
    }

    public static boolean isElementPresentV2(By byElement) {
        try{
            return driver.findElement(byElement)!= null;
        } catch (Exception e) {
            return false;
        }
    }

    public static Boolean waitElementIsRemoved(By isTeamDeleted){
        boolean result = true;
        int count = 0;
        int MaxCount = 10;
        try {
            while (result && count <= MaxCount){
                Thread.sleep(50);
                System.out.println("************************** aqui entre ******************");
                result = isElementPresent(isTeamDeleted);
                System.out.println("////////////////////////// aqui entre ////////////////" + result);
                count++;
            }
        } catch (InterruptedException e){
            log.error("Exception Found Element is not Present");
        }
        return result;
    }

    public static WebElement findMember(By member){
        memberFound = driver.findElement(member);
        return memberFound;
    }

    public static WebElement getStaleElem(By by) {
        try {
            return driver.findElement(by);
        } catch (StaleElementReferenceException e) {
            //System.out.println("Attempting to recover from StaleElementReferenceException ...");
            return getStaleElem(by);
        } catch (NoSuchElementException ele) {
            //System.out.println("Attempting to recover from NoSuchElementException ...");
            return getStaleElem(by);
        }
    }

    public static String getPathBoard(String nameBoard){
        return "";
    }
}
