package com.solvd.ecommerce.mobile.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ecommerce.mobile.common.LoginPageBase;
import com.solvd.ecommerce.mobile.common.LoginWithEmailPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(id = "loginFormLoginEmailLink")
    private ExtendedWebElement loginWithEmailFormButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public LoginWithEmailPageBase openLoginWithEmailButton() {
        loginWithEmailFormButton.click();
        return initPage(getDriver(), LoginWithEmailPageBase.class);
    }

}