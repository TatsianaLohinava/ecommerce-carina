package com.solvd.ecommerce.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ecommerce.mobile.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = ".//input[contains(@class, 'header__search-toggle')]")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = ".//button[@class='search-form__submit']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = ".//a[contains(@class, 'header__item') and contains(@class, 'header__item_toggle') and contains(@href, '#menu')]")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = ".//*[contains(@class, 'menu') and contains(@class, 'offcanvas') and contains(@class, 'offcanvas-end')]")
    private ExtendedWebElement menuCard;

    @FindBy(xpath = ".//*[contains(@class, 'btn-close')]")
    private ExtendedWebElement closeMenuButton;

    @FindBy(xpath = ".//a[contains(@class, 'header__item') and contains(@class, 'header__item_toggle') and contains(@title, 'Отменить')]")
    private ExtendedWebElement resetButton;

    @FindBy(xpath = ".//a[contains(@class, 'navbar__item') and contains(@href, 'myoz')]")
    private ExtendedWebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void focusOnInput() {
        tap(searchBar);
    }

    @Override
    public void sendKeysToInput(String query) {
        ((JavascriptExecutor) driver).executeScript("document.activeElement.value='" + query + "';");
    }

    @Override
    public void clickMenuButton() {
        menuButton.click();
    }

    @Override
    public void clickResetButton() {
        resetButton.click();
    }

    @Override
    public boolean isSearchInputEmpty() {
        String value = searchBar.getAttribute("value");
        return value.isEmpty();
    }

    @Override
    public boolean isMenuVisible() {
        String classList = menuCard.getAttribute("class");
        return classList.contains("show");
    }

    @Override
    public void clickCloseMenuButton() {
        closeMenuButton.click();
    }

    @Override
    public ResultPageBase openResultPageBase() {
        searchButton.click();
        return initPage(getDriver(), ResultPageBase.class);
    }

    @Override
    public LoginPageBase openLoginPage() {
        loginButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

}