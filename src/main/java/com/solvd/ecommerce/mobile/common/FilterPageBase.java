package com.solvd.ecommerce.mobile.common;

import org.openqa.selenium.WebDriver;

public abstract class FilterPageBase extends BasePage {

    public FilterPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void checkNewItemFilterBox();

    public abstract ResultPageBase clickFilterApplyButton();

}