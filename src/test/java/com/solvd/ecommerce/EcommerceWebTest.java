package com.solvd.ecommerce;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.ecommerce.web.component.*;
import com.solvd.ecommerce.web.page.HomePage;
import com.solvd.ecommerce.web.page.ResultPage;
import com.solvd.ecommerce.web.utils.CapabilitiesFactory;

import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.agent.core.registrar.TestRail;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EcommerceWebTest implements IAbstractTest {

    @BeforeSuite
    public void setUp() {
        TestRail.setSuiteId("S182");
    }

    @Test(enabled = false)
    @Parameters({"browser"})
    public void verifySearchResultTest(String browser) {
        HomePage homePage = new HomePage(getDriver(browser, CapabilitiesFactory.createCapability(browser)));
        homePage.open();
        String query = "Ластик";

        Header header = homePage.getHeader();
        SearchBar searchBar = header.getSearchBar();
        searchBar.searchInputEnter(query);
        ResultPage resultPage = searchBar.searchButtonClick();
        Assert.assertNotEquals(resultPage.getResultListSize(), 0, "There are no query results on this page.");
        resultPage.getResultTableElementList().forEach(ResultTableElement::printItemData);
    }

    @Test
    @TestRailCaseId("C3506")
    @Parameters({"browser"})
    public void checkBackgroundChangeTest(String browser) {
        HomePage homePage = new HomePage(getDriver(browser, CapabilitiesFactory.createCapability(browser)));
        homePage.open();
        SoftAssert softAssert = new SoftAssert();
        List<String> attributeList = homePage.getSideBarMenuElementAttributeOnHover();
        attributeList.forEach(el -> {
            softAssert.assertTrue(el.contains("main-nav__list__li_wnav_active"), "Some of the menu elements haven't changed appearance on hover.");
        });
        softAssert.assertAll();
    }

    @Test
    @TestRailCaseId("C3507")
    @Parameters({"browser"})
    public void checkPinButtonTest(String browser) {
        HomePage homePage = new HomePage(getDriver(browser, CapabilitiesFactory.createCapability(browser)));
        homePage.open();

        SoftAssert softAssert = new SoftAssert();
        homePage.getCategoryHeadingWithPinList().forEach(el -> Assert.assertTrue(el, "Some category headings haven't changed the appearance."));
        softAssert.assertAll();
    }

    @Test
    @TestRailCaseId("C3508")
    @Parameters({"browser"})
    public void checkInputResetTest(String browser) {
        HomePage homePage = new HomePage(getDriver(browser, CapabilitiesFactory.createCapability(browser)));
        homePage.open();
        String query = "Ластик";

        Header header = homePage.getHeader();
        SearchBar searchBar = header.getSearchBar();
        searchBar.searchInputEnter(query);
        searchBar.clickResetButton();
        Assert.assertTrue(searchBar.isSearchInputEmpty(), "Input wasn't cleared.");
    }

    @Test
    @TestRailCaseId("C3509")
    @Parameters({"browser"})
    public void checkSearchFilterResultTest(String browser) {
        HomePage homePage = new HomePage(getDriver(browser, CapabilitiesFactory.createCapability(browser)));
        homePage.open();
        String query = "Ластик";

        Header header = homePage.getHeader();
        SearchBar searchBar = header.getSearchBar();
        SoftAssert softAssert = new SoftAssert();

        searchBar.searchInputEnter(query);
        ResultPage resultPage = searchBar.searchButtonClick();

        boolean isNewFilterChecked = resultPage.checkNewFilterBox();

        if (isNewFilterChecked) {
            List<ResultTableElement> resultTableElementList = resultPage.getResultTableElementList();
            resultTableElementList.forEach(el -> softAssert.assertTrue(el.checkNewItem(), "Some items do not contain the label"));

            softAssert.assertAll();
        }
    }

    @Test
    @TestRailCaseId("C3510")
    @Parameters({"browser"})
    public void checkInvalidLoginDataTest(String browser) {
        HomePage homePage = new HomePage(getDriver(browser, CapabilitiesFactory.createCapability(browser)));
        homePage.open();
        Header header = homePage.getHeader();
        LoginBox loginBox = homePage.getLoginBox();
        LoginForm loginForm = loginBox.getLoginForm();
        header.clickMainLoginButton();
        loginBox.clickLoginWithEmailButton();
        loginForm.fillEmailInput(R.TESTDATA.get("email"));
        loginForm.fillPasswordInput(R.TESTDATA.get("pass"));
        loginForm.clickLoginFormButton();
        Assert.assertTrue(loginForm.isWarningMessagePresent(), "Warning message is not shown.");
    }

}