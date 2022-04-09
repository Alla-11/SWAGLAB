package org.tms.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

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
        return nameOfMainPageSection.getText();
    }

    public List<WebElement> getListButtonAddToCart(){
        return buttonsAddToCart;
    }

    public List<WebElement> getListButtonRemoveFromCart(){
        return buttonsRemoveFromCart;
    }

    public String getNumberOfProductsInTheCartAfterAdd(WebElement buttonAddToCart){
        buttonAddToCart.click();
        return numberOfProductsInTheCart.getText();
    }

    public void clickRemoveProductsInTheCart(WebElement buttonRemoveFromCart){
        buttonRemoveFromCart.click();
    }

    public WebElement getIndicatorOfCart(){
        return numberOfProductsInTheCart;
    }

    public List <WebElement> getListOfProductPrices(){
        ArrayList <WebElement> pricelistOnPageOfProducts = new ArrayList<>();
        for (WebElement element:productPrice) {
            pricelistOnPageOfProducts.add(element);
        }
        return pricelistOnPageOfProducts;
    }

    public void clickSelectFromSmallToLargePrices(){
        Select select = new Select(productSelect);
        select.selectByVisibleText(valueOfSelectFromSmallToLarge.getText());
    }
}








