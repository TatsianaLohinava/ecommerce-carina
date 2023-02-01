package com.solvd.ecommerce.mobile.common;

import org.openqa.selenium.WebDriver;

public abstract class AppPageBase extends BasePage {

    public AppPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void closeControlPanel();

    public abstract void openFirstTab();

    public abstract void switchTab();

    public abstract void closeTab();

}