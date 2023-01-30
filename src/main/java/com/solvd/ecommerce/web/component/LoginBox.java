package com.solvd.ecommerce.web.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginBox extends AbstractUIObject {

    @FindBy(id = "loginFormLoginEmailLink")
    private ExtendedWebElement emailLoginTab;

    @FindBy(id = "loginForm")
    private LoginForm loginForm;

    public LoginBox(WebDriver webDriver, SearchContext searchContext) {
        super(webDriver, searchContext);
    }

    public void clickLoginWithEmailButton() {
        emailLoginTab.click();
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

}