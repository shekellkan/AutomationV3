package common;

import ui.PageTransporter;
import ui.pages.LoginPage;
import ui.pages.MainPage;
import ui.pages.TopMenuPage;

/**
 * Created by Miguel Terceros on 24/11/2015.
 */

public class CommonMethods {
    private static PageTransporter pageTransporter = PageTransporter.getInstance();
    private static TopMenuPage topMenuPage;
    private static LoginPage loginPage;
    private static MainPage mainPage;

    public static boolean isLogin;
    public static boolean isLogout;

    public static void logOut() {
        topMenuPage = new TopMenuPage();
        topMenuPage.logout();
        isLogout = true;
    }

    public static void logIn() {
        loginPage = pageTransporter.navigateToLoginPage();
        loginPage.loginSuccessful("miguel.terceros@fundacion-jala.org", "morfeo3730");
        isLogin = true;
    }

    public static boolean isLogIn(){
        return isLogin;
    }

    public static boolean isLogOut(){
        return isLogout;
    }
}
