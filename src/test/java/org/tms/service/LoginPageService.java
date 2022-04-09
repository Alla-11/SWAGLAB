package org.tms.service;

import org.tms.model.User;
import org.tms.page.InventoryPage;
import org.tms.page.LoginPage;

public class LoginPageService {

    private static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";

    private User user = new User();

    private LoginPage loginPage = new LoginPage();

    public InventoryPage login(){
        loginPage.openPage(LOGIN_PAGE_URL)
                .fillInUsername(user.getName())
                .fillInPassword(user.getPassword())
                .clickLoginButton();
        return new InventoryPage();
    }
}

