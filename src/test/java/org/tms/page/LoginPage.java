package org.tms.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends Page {

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passsword;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    public LoginPage openPage(String url) {
        log.info("open Login page");
        driver.get(url);
        return this;
    }

    public LoginPage fillInUsername(String userName) {
        log.info("Enter login");
        username.clear();
        username.sendKeys(userName);
        return this;
    }

    public LoginPage fillInPassword(String keyPassword) {
        log.info("Enter password");
        passsword.clear();
        passsword.sendKeys(keyPassword);
        return this;
    }

    public void clickLoginButton() {
        log.info("Click on the loggin button");
        loginButton.click();
    }

}

