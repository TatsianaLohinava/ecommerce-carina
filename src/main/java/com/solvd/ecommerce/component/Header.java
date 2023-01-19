package com.solvd.ecommerce.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(css = ".top-panel__search__inner")
    private SearchBar searchBar;

    @FindBy(xpath = ".//a[@class = 'top-panel__userbar__auth']")
    private ExtendedWebElement mainLoginButton;

    public Header(WebDriver webDriver, SearchContext searchContext) {
        super(webDriver, searchContext);
    }

    public void clickMainLoginButton() {
        mainLoginButton.click();
    }

    public SearchBar getSearchBar() {
        return searchBar;
    }

}