package com.solvd.ecommerce.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.ecommerce.page.ResultPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchBar extends AbstractUIObject {

    @FindBy(css = "#top-s")
    private ExtendedWebElement searchInput;

    @FindBy(css = ".top-panel__search__btn")
    private ExtendedWebElement searchButton;

    @FindBy(css = ".input-reset")
    private ExtendedWebElement inputResetButton;

    public SearchBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void searchInputEnter(String query) {
        searchInput.type(query);
    }

    public ResultPage searchButtonClick() {
        searchButton.click();
        return new ResultPage(getDriver());
    }

    public void clickResetButton() {
        inputResetButton.click();
    }

    public boolean isSearchInputEmpty() {
        String value = searchInput.getAttribute("value");
        return value.isEmpty();
    }

}