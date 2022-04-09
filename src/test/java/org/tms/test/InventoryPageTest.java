package org.tms.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.page.InventoryPage;
import org.tms.service.LoginPageService;
import java.util.Random;

public class InventoryPageTest extends BaseTest{

    private LoginPageService loginPageService = new LoginPageService();
    private InventoryPage inventoryPage = new InventoryPage();


    @BeforeClass
    public void lodinTest(){
        loginPageService.login();
    }

    @Test
    public void addProductToCartTest(){
        String actualNumberOfProductsInTheCartAfterAdd = inventoryPage.getNumberOfProductsInTheCartAfterAdd(returnButtonSelectElementToAdd());
        String expectedNumberOfProductsInTheCartAfterAdd = getNumberOfProductsInTheCart();
        System.out.println("Test 2");
        Assert.assertEquals(actualNumberOfProductsInTheCartAfterAdd,expectedNumberOfProductsInTheCartAfterAdd,"The actual number of products in the cart does not match expected after add!");
    }

    @Test (dependsOnMethods = "addProductToCartTest")
    public void removeProductFromCartTest(){
        Integer expectedNumberOfProductsInTheCartAfterRemove = getNumberOfClickOnButtonAfterRemove();
        inventoryPage.clickRemoveProductsInTheCart(returnButtonSelectElementAfterRemove());
        String actualNumberOfProductsInTheCartAfterRemove = getNumberOfProductsInTheCart();
        Assert.assertEquals(actualNumberOfProductsInTheCartAfterRemove,expectedNumberOfProductsInTheCartAfterRemove.toString(),"The actual number of products in the cart does not match expected after remove!");
    }



    private Integer returnIndexSelectElementToAdd(){
        Random randomIndex = new Random();
        Integer indexSelectElementToAdd = randomIndex.nextInt(inventoryPage.getListButtonAddToCart().size())-1;
        return indexSelectElementToAdd;
    }

    private Integer returnIndexSelectElementFromRemove(){
        Random randomIndex = new Random();
        Integer indexSelectElementFromRemove = randomIndex.nextInt(inventoryPage.getListButtonRemoveFromCart().size());
        return indexSelectElementFromRemove;

    }

    private WebElement returnButtonSelectElementToAdd(){
        WebElement buttonSelectElementToAdd = null;
        buttonSelectElementToAdd = inventoryPage.getListButtonAddToCart().get(returnIndexSelectElementToAdd());
        return buttonSelectElementToAdd;
    }

    private WebElement returnButtonSelectElementAfterRemove(){
        WebElement buttonSelectElementAfterRemove = null;
        buttonSelectElementAfterRemove = inventoryPage.getListButtonRemoveFromCart().get(returnIndexSelectElementFromRemove());
        return buttonSelectElementAfterRemove;
    }

    private String getNumberOfProductsInTheCart(){
        String numberOfProductsInTheCartText;
        if (inventoryPage.getIndicatorOfCart().getText().equals("")){
            numberOfProductsInTheCartText = "0";
        } else {
            numberOfProductsInTheCartText = inventoryPage.getIndicatorOfCart().getText();
        }
        return numberOfProductsInTheCartText;
    }

    private Integer getNumberOfClickOnButtonAfterRemove(){
        Integer numberOfProductsInTheCartBeforeRemove = Integer.valueOf(getNumberOfProductsInTheCart());
        Integer numberOfProductsInTheCartAfterRemove = numberOfProductsInTheCartBeforeRemove - 1;
        return numberOfProductsInTheCartAfterRemove;
    }
}







