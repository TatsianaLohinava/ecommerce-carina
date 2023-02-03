package com.solvd.ecommerce;

import com.qaprosoft.carina.core.foundation.IAbstractTest;

import com.solvd.ecommerce.mobile.common.*;
import com.solvd.ecommerce.mobile.android.*;
import com.solvd.ecommerce.utils.ContextView;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.*;

public class EcommerceAndroidTest implements IAbstractTest {

    @Test
    public void verifySearchResultTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        String query = "Ластик";

        homePage.focusOnInput();
        homePage.sendKeysToInput(query);
        ResultPageBase resultPage = homePage.openResultPageBase();

        Assert.assertNotEquals(resultPage.getResultListSize(), 0, "There are no query results on this page.");
        resultPage.printItemData();

        resultPage.switchContext(ContextView.APP.getContextView());
        AppPage appPage = new AppPage(getDriver());
        appPage.switchTab();
        appPage.closeTab();
        Assert.assertFalse(appPage.isAppRunning(), "App was not closed.");
    }

    @Test
    public void checkMenuButtonTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();

        homePage.clickMenuButton();
        Assert.assertTrue(homePage.isMenuVisible(), "Menu is not visible.");
        homePage.clickDeliveryElement();
        homePage.switchContext(ContextView.APP.getContextView());

        AppPage appPage = new AppPage(getDriver());
        appPage.openFirstTab();
        appPage.switchContext(ContextView.WEB.getContextView());

        Assert.assertTrue(homePage.checkPageUrl(), "The page url is different from the original.");
        homePage.clickCloseMenuButton();
        Assert.assertFalse(homePage.isMenuVisible(), "Menu is visible.");
    }

    @Test
    public void checkInputResetTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        String query = "Ластик";

        homePage.focusOnInput();
        homePage.sendKeysToInput(query);
        homePage.clickResetButton();

        Assert.assertTrue(homePage.isSearchInputEmpty(), "Input wasn't cleared.");
    }

    @Test
    public void checkSearchFilterResultTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        String query = "Ластик";

        homePage.switchContext(ContextView.APP.getContextView());
        AppPage appPage = new AppPage(getDriver());
        appPage.closeControlPanel();
        appPage.switchContext(ContextView.WEB.getContextView());

        homePage.focusOnInput();
        homePage.sendKeysToInput(query);
        ResultPageBase resultPage = homePage.openResultPageBase();

        FilterPageBase filterPage = resultPage.openFilterPage();

        filterPage.checkNewItemFilterBox();
        filterPage.clickFilterApplyButton();

        Assert.assertEquals(resultPage.getNewLabelListSize(), resultPage.getResultListSize(), "Quantity of the labels isn't equal to the quantity of items.");
    }

    @Test
    public void checkInvalidLoginDataTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        LoginPageBase loginPage = homePage.openLoginPage();

        LoginWithEmailPageBase loginWithEmailPage = loginPage.openLoginWithEmailButton();

        loginWithEmailPage.fillEmailInput(R.TESTDATA.get("email"));
        loginWithEmailPage.fillPasswordInput(R.TESTDATA.get("pass"));
        loginWithEmailPage.clickSubmitDataButton();

        Assert.assertTrue(loginWithEmailPage.isWarningMessagePresent(), "Warning message is not shown.");
    }

}