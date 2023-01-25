package com.solvd.ecommerce.mobile.common;

import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends BasePage {

    public LoginPageBase(WebDriver webDriver) {
        super(webDriver);
    }

    public abstract LoginWithEmailPageBase openLoginWithEmailButton();

}