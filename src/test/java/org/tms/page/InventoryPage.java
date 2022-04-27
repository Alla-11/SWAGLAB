package org.tms.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

@Log4j2
public class InventoryPage extends Page {

    @FindBy(xpath = "//span[@class='title']")
    private WebElement nameOfMainPageSection;

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    private List <WebElement> buttonsAddToCart;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement numberOfProductsInTheCart;

    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small btn_inventory']")
    private List <WebElement> buttonsRemoveFromCart;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> productPrice;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement productSelect;

    @FindBy(xpath = "//option[@value='lohi']")
    private WebElement valueOfSelectFromSmallToLarge;


    public String getTextOfNameOfMainPageSection(){
        log.info("Get text of name page ");
        return nameOfMainPageSection.getText();
    }

    public List<WebElement> getListButtonAddToCart(){
        log.info("Get list of buttons 'Add'");
        return buttonsAddToCart;
    }

    public List<WebElement> getListButtonRemoveFromCart(){
        log.info("Get list of buttons 'Remove'");
        return buttonsRemoveFromCart;
    }

    public String getNumberOfProductsInTheCartAfterAdd(WebElement buttonAddToCart){
        log.info("Get number of products in the cart after add");
        buttonAddToCart.click();
        return numberOfProductsInTheCart.getText();
    }

    public void clickRemoveProductsInTheCart(WebElement buttonRemoveFromCart){
        log.info("Click remove products in the cart");
        buttonRemoveFromCart.click();
    }

    public WebElement getIndicatorOfCart(){
        log.info("get value of cart indicator");
        return numberOfProductsInTheCart;
    }

    public List <WebElement> getListOfProductPrices(){
        log.info("get list of product prices");
        ArrayList <WebElement> pricelistOnPageOfProducts = new ArrayList<>();
        for (WebElement element:productPrice) {
            pricelistOnPageOfProducts.add(element);
        }
        return pricelistOnPageOfProducts;
    }

    public void clickSelectFromSmallToLargePrices(){
        log.info("filter products small to large prices");
        Select select = new Select(productSelect);
        select.selectByVisibleText(valueOfSelectFromSmallToLarge.getText());
    }
}








