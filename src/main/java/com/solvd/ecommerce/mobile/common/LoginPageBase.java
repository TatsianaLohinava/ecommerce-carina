package com.solvd.ecommerce.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver webDriver) {
        super(webDriver);
    }

    public abstract LoginWithEmailPageBase openLoginWithEmailButton();

}