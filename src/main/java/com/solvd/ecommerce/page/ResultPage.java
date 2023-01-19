package com.solvd.ecommerce.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.ecommerce.component.ResultTableElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage extends AbstractPage {

    @FindBy(xpath = ".//*[@class = 'item-type-card']")
    private List<ResultTableElement> resultTableElementList;

    @FindBy(xpath = ".//*[@class = 'link-facet-bot' and text() = 'Новинки']")
    private ExtendedWebElement newFilterCheckbox;

    public ResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public int getResultListSize() {
        return resultTableElementList.size();
    }

    public boolean checkNewFilterBox() {
        return newFilterCheckbox.clickIfPresent();
    }

    public List<ResultTableElement> getResultTableElementList() {
        return resultTableElementList;
    }

}