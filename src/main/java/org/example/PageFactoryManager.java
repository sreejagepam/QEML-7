package org.example;

import org.openqa.selenium.WebDriver;
import org.example.pages.*;

public class PageFactoryManager {

    public static LoginPage getLoginPage(WebDriver driver) {
        return new LoginPage(driver);
    }

    public static RegisterPage getRegisterPage(WebDriver driver) {
        return new RegisterPage(driver);
    }

    public static CreateUserPage getCreateUserPage(WebDriver driver) {
        return new CreateUserPage(driver);
    }
}
