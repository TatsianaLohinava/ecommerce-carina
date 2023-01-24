package com.solvd.ecommerce;

import com.qaprosoft.carina.core.foundation.IAbstractTest;

import com.solvd.ecommerce.mobile.android.*;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.*;

public class EcommerceAndroidTest implements IAbstractTest {

    @Test
    public void verifySearchResultTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        String query = "Ластик";

        homePage.focusOnInput();
        homePage.sendKeysToInput(query);
        homePage.openResultPageBase();

        ResultPage resultPage = new ResultPage(getDriver());
        Assert.assertNotEquals(resultPage.getResultListSize(), 0);
        resultPage.printItemData();
    }

    @Test
    public void checkMenuButtonTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        homePage.clickMenuButton();
        Assert.assertTrue(homePage.isMenuVisible());
        homePage.clickCloseMenuButton();
        Assert.assertFalse(homePage.isMenuVisible());
    }

    @Test
    public void checkInputResetTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        String query = "Ластик";

        homePage.focusOnInput();
        homePage.sendKeysToInput(query);
        homePage.clickResetButton();

        Assert.assertTrue(homePage.isSearchInputEmpty());
    }

    @Test
    public void checkSearchFilterResultTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        String query = "Ластик";

        homePage.focusOnInput();
        homePage.sendKeysToInput(query);
        homePage.openResultPageBase();

        ResultPage resultPage = new ResultPage(getDriver());
        resultPage.openFilterPage();

        FilterPage filterPage = new FilterPage(getDriver());
        filterPage.checkNewItemFilterBox();
        filterPage.clickFilterApplyButton();

        Assert.assertEquals(resultPage.getNewLabelListSize(), resultPage.getResultListSize());
    }

    @Test
    public void checkInvalidLoginDataTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.openLoginWithEmailButton();

        LoginWithEmailPage loginWithEmailPage = new LoginWithEmailPage(getDriver());
        loginWithEmailPage.fillEmailInput(R.TESTDATA.get("email"));
        loginWithEmailPage.fillPasswordInput(R.TESTDATA.get("pass"));
        loginWithEmailPage.clickSubmitDataButton();

        Assert.assertTrue(loginWithEmailPage.isWarningMessagePresent());
    }

}