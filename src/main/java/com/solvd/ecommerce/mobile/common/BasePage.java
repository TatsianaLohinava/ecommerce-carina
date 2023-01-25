package com.solvd.ecommerce.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends AbstractPage implements IMobileUtils {

    public BasePage(WebDriver driver) {
        super(driver);
    }
}