package com.solvd.ecommerce.web.utils;

import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.FirefoxCapabilities;
import org.openqa.selenium.MutableCapabilities;

public class CapabilitiesFactory {

    public static MutableCapabilities createCapability(String browserName) {
        MutableCapabilities mutableCapabilities = null;
        if (browserName.equals("chrome")) {
            mutableCapabilities = new ChromeCapabilities().getCapability("ChromeTest");
        } else if (browserName.equals("firefox")) {
            mutableCapabilities = new FirefoxCapabilities().getCapability("FirefoxTest");
        }
        return mutableCapabilities;
    }

}