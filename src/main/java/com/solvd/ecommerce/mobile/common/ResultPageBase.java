package com.solvd.ecommerce.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ResultPageBase extends AbstractPage {

    public ResultPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract FilterPageBase openFilterPage();

    public abstract int getResultListSize();

    public abstract void printItemData();

    public abstract int getNewLabelListSize();

}