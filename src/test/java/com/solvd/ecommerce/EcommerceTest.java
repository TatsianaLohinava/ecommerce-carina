package com.solvd.ecommerce;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.ecommerce.component.*;
import com.solvd.ecommerce.page.*;
import com.solvd.ecommerce.utils.CapabilitiesFactory;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EcommerceTest implements IAbstractTest {

    @Test
    @Parameters({"browser"})
    public void verifySearchResultTest(String browser) {
        HomePage homePage = new HomePage(getDriver(browser, CapabilitiesFactory.createCapability(browser)));
        homePage.open();
        String query = "Ластик";

        Header header = homePage.getHeader();
        SearchBar searchBar = header.getSearchBar();
        searchBar.searchInputEnter(query);
        ResultPage resultPage = searchBar.searchButtonClick();
        Assert.assertNotEquals(resultPage.getResultListSize(), 0);
        resultPage.getResultTableElementList().forEach(ResultTableElement::printItemData);
    }

    @Test
    @Parameters({"browser"})
    public void checkBackgroundChangeTest(String browser) {
        HomePage homePage = new HomePage(getDriver(browser, CapabilitiesFactory.createCapability(browser)));
        homePage.open();
        SoftAssert sa = new SoftAssert();
        List<String> attributeList = homePage.getSideBarMenuElementAttributeOnHover();
        attributeList.forEach(el -> {
            sa.assertTrue(el.contains("main-nav__list__li_wnav_active"));
        });
        sa.assertAll();
    }

    @Test
    @Parameters({"browser"})
    public void checkPinButtonTest(String browser) {
        HomePage homePage = new HomePage(getDriver(browser, CapabilitiesFactory.createCapability(browser)));
        homePage.open();

        SoftAssert sa = new SoftAssert();
        List<CategorySection> classList = homePage.getCategorySectionList();
        for (CategorySection cs : classList) {
            cs.clickPinButton();
            sa.assertTrue(cs.getHeadingWithoutPinClass());
        }

        sa.assertAll();
    }

    @Test
    @Parameters({"browser"})
    public void checkInputResetTest(String browser) {
        HomePage homePage = new HomePage(getDriver(browser, CapabilitiesFactory.createCapability(browser)));
        homePage.open();
        String query = "Ластик";

        Header header = homePage.getHeader();
        SearchBar searchBar = header.getSearchBar();
        searchBar.searchInputEnter(query);
        searchBar.clickResetButton();
        Assert.assertTrue(searchBar.isSearchInputEmpty());
    }

    @Test
    @Parameters({"browser"})
    public void checkSearchFilterResultTest(String browser) {
        HomePage homePage = new HomePage(getDriver(browser, CapabilitiesFactory.createCapability(browser)));
        homePage.open();
        String query = "Ластик";

        Header header = homePage.getHeader();
        SearchBar searchBar = header.getSearchBar();
        SoftAssert sa = new SoftAssert();

        searchBar.searchInputEnter(query);
        ResultPage resultPage = searchBar.searchButtonClick();

        boolean bool = resultPage.checkNewFilterBox();
        Assert.assertTrue(bool);
        if (bool) {
            List<ResultTableElement> resultTableElementList = resultPage.getResultTableElementList();
            resultTableElementList.forEach(el -> sa.assertTrue(el.checkNewItem()));

            sa.assertAll();
        }
    }

    @Test
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
        Assert.assertTrue(loginForm.isElementWithTextPresent(loginForm.getWarningMessage(), "Адрес электронной почты не зарегистрирован."));
    }

}