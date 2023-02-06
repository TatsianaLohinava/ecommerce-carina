package com.solvd.ecommerce.mobile.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.ecommerce.mobile.common.AppPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AppPage extends AppPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == 'Tabs'`]")
    private ExtendedWebElement tabSwitchButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == 'Close This Tab'`]")
    private ExtendedWebElement tabCloseButton;

    @FindBy(id = "tab_strip_item_button")
    private List<ExtendedWebElement> tabMainPage;

    public AppPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void closeControlPanel() {
    }

    @Override
    public void openFirstTab() {
        switchTab();
        closeTab();
    }

    @Override
    public void switchTab() {
        tap(tabSwitchButton);
    }

    @Override
    public void closeTab() {
        tap(tabCloseButton);
    }

}