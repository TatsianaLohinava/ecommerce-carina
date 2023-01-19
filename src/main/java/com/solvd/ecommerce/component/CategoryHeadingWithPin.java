package com.solvd.ecommerce.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class CategoryHeadingWithPin extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@class, 'i-oz') and contains(@class, 'mpgs-unpin')]")
    private ExtendedWebElement pinButton;

    public CategoryHeadingWithPin(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickPinButton() {
        pinButton.click();
    }

}