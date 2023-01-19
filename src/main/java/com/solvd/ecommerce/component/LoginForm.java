package com.solvd.ecommerce.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AbstractUIObject {

    @FindBy(xpath = ".//input[@type = 'email']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = ".//input[@type = 'password']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = ".//*[@value = 'login' and text() = 'Войти']")
    private ExtendedWebElement loginFormButton;

    @FindBy(xpath = ".//*[@class = 'i-popover__line']")
    private ExtendedWebElement warningMessage;

    public LoginForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void fillEmailInput(String string) {
        emailInput.type(string);
    }

    public void fillPasswordInput(String string) {
        passwordInput.type(string);
    }

    public void clickLoginFormButton() {
        loginFormButton.click();
    }

    public ExtendedWebElement getWarningMessage() {
        return warningMessage;
    }

}