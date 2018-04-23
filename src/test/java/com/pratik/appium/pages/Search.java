package com.pratik.appium.pages;

import com.pratik.appium.logger.LogUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class Search extends BasePage {

    public Search(AppiumDriver driver) {
        super(driver);
        LogUtils.INFO("Instantiated " + Search.class.getName());
    }

    private String searchBarLocator = "search_src_text";
    private String firstSearchResult = "text";


    public Search searchProduct(String searchItem) {
        LogUtils.INFO(" **** SEARCHING FOR PRODUCT :"+ searchItem + "**** ");
        driver.findElement(By.id(searchBarLocator)).sendKeys(searchItem);
        waitForElementToBePresent(By.id(firstSearchResult),10);
        click(By.id(firstSearchResult));
        return this;
    }

}
