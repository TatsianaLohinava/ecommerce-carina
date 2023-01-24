package com.solvd.ecommerce.web.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultTableElement extends AbstractUIObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultTableElement.class);

    @FindBy(xpath = ".//*[@class = 'item-type-card__title']")
    private ExtendedWebElement resultName;

    @FindBy(xpath = ".//*[@class = 'item-type-card__info']")
    private ExtendedWebElement resultBrand;

    @FindBy(xpath = ".//*[contains(@class, 'product-label_new')]")
    private ExtendedWebElement newLabel;

    public ResultTableElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void printItemData() {
        LOGGER.info(resultName.getText() + " " + resultBrand.getText());
    }

    public boolean checkNewItem() {
        return newLabel.isElementPresent();
    }

}