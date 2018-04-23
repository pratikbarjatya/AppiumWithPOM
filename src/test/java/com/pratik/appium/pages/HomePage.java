package com.pratik.appium.pages;

import com.pratik.appium.logger.LogUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class HomePage extends BasePage {

    private String searchBarLocator = "search_box";
    private String sideMenuItemLocator = "home";

    public HomePage(AppiumDriver driver) {
        super(driver);
        LogUtils.INFO("Instantiated " + HomePage.class.getName());
    }

    public void searchBox() {
        waitForElementToBePresent(By.id(searchBarLocator), 5);
        click(By.id(searchBarLocator));
    }


}
