package com.solvd.ecommerce.mobile.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ecommerce.mobile.common.FilterPageBase;
import com.solvd.ecommerce.mobile.common.ResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = FilterPageBase.class)
public class FilterPage extends FilterPageBase {

    @FindBy(xpath = ".//*[contains(@class, 'filters__chkslist__item') and contains(@for, 'nw_1')]")
    private ExtendedWebElement newItemsFilterButton;

    @FindBy(xpath = ".//*[@id = 'f-results']")
    private ExtendedWebElement filterApplyButton;

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void checkNewItemFilterBox() {
        newItemsFilterButton.click();
    }

    @Override
    public ResultPageBase clickFilterApplyButton() {
        filterApplyButton.click();
        return initPage(getDriver(), ResultPageBase.class);
    }

}