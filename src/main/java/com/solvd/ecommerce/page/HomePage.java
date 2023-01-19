package com.solvd.ecommerce.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.ecommerce.component.CategorySection;
import com.solvd.ecommerce.component.Header;
import com.solvd.ecommerce.component.LoginBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(css = ".top-panel.page-init-scroll")
    private Header header;

    @FindBy(id = "loginPopup")
    private LoginBox loginBox;

    @FindBy(css = ".main-nav__list__li.main-nav__list__li_wnav")
    private List<ExtendedWebElement> sidebarMenuList;

    @FindBy(xpath = ".//*[contains(@id, 'category_goods_container')]")
    private List<CategorySection> categorySection;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        setPageURL("");
    }

    public Header getHeader() {
        return header;
    }

    public LoginBox getLoginBox() {
        return loginBox;
    }

    public List<CategorySection> getCategorySectionList() {
        return categorySection;
    }

    public List<String> getSideBarMenuElementAttributeOnHover() {
        List<String> attributeList = new ArrayList<>();
        for (ExtendedWebElement el : sidebarMenuList) {
            el.hover();
            attributeList.add(el.getAttribute("class"));
        }
        return attributeList;
    }

}