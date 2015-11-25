package common;

import ui.pages.LoginPage;
import ui.pages.MainPage;
import ui.pages.TopMenuPage;

/**
 * Created by Miguel Terceros on 24/11/2015.
 */
public class CommonMethods {

    public static boolean isLogin;
    public static boolean isLogout;

    public static void logIn(String username, String password){
        LoginPage loginPage = new LoginPage();
        loginPage.loginSuccessful(username, password);
        isLogin = true;
    }

    public static void logOut(){
        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.logout();
        isLogout = true;
    }

    public static boolean isLogIn(){
        return isLogin;
    }

    public static boolean isLogOut(){
        return isLogout;
    }
}
