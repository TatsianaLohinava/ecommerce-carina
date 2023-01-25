package com.solvd.ecommerce.mobile.common;

import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends BasePage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ResultPageBase openResultPageBase();

    public abstract LoginPageBase openLoginPage();

    public abstract void clickCloseMenuButton();

    public abstract boolean isMenuVisible();

    public abstract boolean isSearchInputEmpty();

    public abstract void clickResetButton();

    public abstract void clickMenuButton();

    public abstract void sendKeysToInput(String query);

    public abstract void focusOnInput();

}