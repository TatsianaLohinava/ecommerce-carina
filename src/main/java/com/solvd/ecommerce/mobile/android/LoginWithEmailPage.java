package com.solvd.ecommerce.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ecommerce.mobile.common.LoginWithEmailPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginWithEmailPageBase.class)
public class LoginWithEmailPage extends LoginWithEmailPageBase {

    @FindBy(xpath = ".//*[@id = 'loginForm']//*[contains(@class, 'i-popup__input') and (@type='email')]")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = ".//*[@id = 'loginForm']//*[contains(@class, 'i-popup__input') and (@type='password')]")
    private ExtendedWebElement passInput;

    @FindBy(xpath = ".//*[contains(@class, 'i-popup__form-button') and (@form='loginForm')]")
    private ExtendedWebElement submitDataButton;

    @FindBy(xpath = ".//*[@id='loginForm']//*[@class='i-popover__line']")
    private ExtendedWebElement warningMessage;

    public LoginWithEmailPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void fillEmailInput(String data) {
        emailInput.type(data);
    }

    @Override
    public void fillPasswordInput(String data) {
        passInput.type(data);
    }

    @Override
    public void clickSubmitDataButton() {
        submitDataButton.click();
    }

    @Override
    public boolean isWarningMessagePresent() {
        return isElementWithTextPresent(warningMessage, "Адрес электронной почты не зарегистрирован");
    }

}