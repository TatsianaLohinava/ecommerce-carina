package com.solvd.ecommerce.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ecommerce.mobile.common.AppPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AppPageBase.class)
public class AppPage extends AppPageBase {

    @FindBy(id = "tab_switcher_button")
    private ExtendedWebElement tabSwitchButton;

    @FindBy(id = "menu_item_icon")
    private List<ExtendedWebElement> tabActionButtonList;

    @FindBy(id = "bottom_container")
    private ExtendedWebElement controlPanel;

    @FindBy(id = "translate_infobar_menu_button")
    private ExtendedWebElement controlPanelSettingBtn;

    @FindBy(id = "menu_item_text")
    private List<ExtendedWebElement> settingsOptionBtnList;

    @FindBy(id = "tab_strip_item_button")
    private List<ExtendedWebElement> tabItemBtnList;

    public AppPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void closeControlPanel() {
        if (controlPanel.isElementPresent()) {
            tap(controlPanelSettingBtn);
            settingsOptionBtnList.get(2).click();
        }
    }

    @Override
    public void openFirstTab() {
        tap(tabItemBtnList.get(0));
    }

    @Override
    public void switchTab() {
        tap(tabSwitchButton);
    }

    @Override
    public void closeTab() {
        tap(tabActionButtonList.get(0));
    }

}