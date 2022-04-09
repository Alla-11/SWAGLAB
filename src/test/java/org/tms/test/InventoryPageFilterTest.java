package org.tms.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.page.InventoryPage;
import org.tms.service.LoginPageService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class InventoryPageFilterTest extends BaseTest{

    private LoginPageService loginPageService = new LoginPageService();
    private InventoryPage inventoryPage = new InventoryPage();

    @BeforeClass
    public void lodinTest(){
        loginPageService.login();
    }

    @Test
    public void sortListTest(){
        List<Double> expectedSortResulLowToHighOnPage = getListOfProductPricesWithoutDollars();
        Collections.sort(expectedSortResulLowToHighOnPage);
        List<Double> actualSortResulLowToHighOnPage = getListOfProductPricesAfterSortLowToHighOnPage();
        Assert.assertEquals(actualSortResulLowToHighOnPage,expectedSortResulLowToHighOnPage,"The actual sorting does not match the expected sorting after the filter (low to high) has run!");
    }


    private List <Double> getListOfProductPricesWithoutDollars(){
        ArrayList<Double> pricelistWithoutDollars = new ArrayList<>();
        for (WebElement element:inventoryPage.getListOfProductPrices()) {
            pricelistWithoutDollars.add(Double.valueOf(element.getText().replace("$","")));
        }
        return pricelistWithoutDollars;
    }

    private List <Double> getListOfProductPricesAfterSortLowToHighOnPage(){
        List<Double> pricelistAfterSortLowToHighOnPageOfProducts = new ArrayList<>();
        inventoryPage.clickSelectFromSmallToLargePrices();
        pricelistAfterSortLowToHighOnPageOfProducts = getListOfProductPricesWithoutDollars();
        return pricelistAfterSortLowToHighOnPageOfProducts;
    }


}



