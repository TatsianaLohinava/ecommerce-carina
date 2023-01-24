package com.solvd.ecommerce.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FilterPageBase extends AbstractPage {

    public FilterPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void checkNewItemFilterBox();

    public abstract ResultPageBase clickFilterApplyButton();

}