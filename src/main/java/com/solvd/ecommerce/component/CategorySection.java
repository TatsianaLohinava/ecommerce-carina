package com.solvd.ecommerce.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategorySection extends AbstractUIObject {

    @FindBy (xpath = "//*[contains(@class, 'i-oz') and contains(@class, 'mpgs-unpin')]")
    private ExtendedWebElement pinButton;

    @FindBy(xpath = "/self::*[not(contains(@class, 'mpgs-nopin'))]")
    private ExtendedWebElement headingWithPin;

    public CategorySection(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickPinButton() {
        pinButton.click();
    }

    public boolean getHeadingWithoutPinClass() {
        return headingWithPin.isElementNotPresent(5l);
    }

}