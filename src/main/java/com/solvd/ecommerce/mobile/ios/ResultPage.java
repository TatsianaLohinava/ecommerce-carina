package com.solvd.ecommerce.mobile.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ecommerce.mobile.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ResultPageBase.class)
public class ResultPage extends ResultPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultPage.class);

    @FindBy(xpath = ".//*[@class = 'item-type-card__title']")
    private List<ExtendedWebElement> resultNameList;

    @FindBy(xpath = ".//*[contains(@class, 'filters-mobile-controls__item--fico')]")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = ".//*[contains(@class, 'product-label_new')]")
    private List<ExtendedWebElement> newLabelList;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public int getResultListSize() {
        return resultNameList.size();
    }

    @Override
    public void printItemData() {
        resultNameList.forEach(el -> LOGGER.info(el.getText()));
    }

    @Override
    public FilterPageBase openFilterPage() {
        filterButton.click();
        return initPage(getDriver(), FilterPageBase.class);
    }

    @Override
    public int getNewLabelListSize() {
        return newLabelList.size();
    }

}