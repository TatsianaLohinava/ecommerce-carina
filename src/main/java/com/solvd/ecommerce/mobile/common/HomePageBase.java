package com.solvd.ecommerce.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage implements IMobileUtils {

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