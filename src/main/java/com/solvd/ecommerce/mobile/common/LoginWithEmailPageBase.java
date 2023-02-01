package com.solvd.ecommerce.mobile.common;

import org.openqa.selenium.WebDriver;

public abstract class LoginWithEmailPageBase extends BasePage {

    public LoginWithEmailPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void fillEmailInput(String data);

    public abstract void fillPasswordInput(String data);

    public abstract void clickSubmitDataButton();

    public abstract boolean isWarningMessagePresent();

}