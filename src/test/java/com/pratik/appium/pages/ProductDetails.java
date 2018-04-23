package com.pratik.appium.pages;

import com.pratik.appium.logger.LogUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProductDetails extends BasePage {

    public ProductDetails(AppiumDriver driver) {
        super(driver);
        LogUtils.INFO("Instantiated " + ProductDetails.class.getName());
    }

    private String watchItLocator = "button_watch";
    private String buyItNowLocator = "button_bin";


    public ProductDetails watchProduct() {
        LogUtils.INFO(" *** WATCHING A PRODUCT **** ");
        waitForElementToBePresent(By.id(watchItLocator), 5);
        click(By.id(watchItLocator));
        return this;
    }
}
