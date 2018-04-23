package com.pratik.appium.pages;

import com.pratik.appium.logger.LogUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchResults extends BasePage {

    public SearchResults(AppiumDriver driver) {
        super(driver);
        LogUtils.INFO("Instantiated " + SearchResults.class.getName());
    }

    private String sortButtonLocator = "button_sort";
    private String productLocator = "search_item_text";
    private String itemCountLocator = "textview_item_count";
    private static ArrayList<List<String>> result = new ArrayList<>();


    public SearchResults sortButton() {
        LogUtils.INFO(" *** CLICK ON SORT BUTTON: **** ");
        waitForElementToBePresent(By.id(sortButtonLocator), 10);
        click(By.id(sortButtonLocator));
        LogUtils.INFO(" *** CLICKED ON SORT BUTTON: **** ");
        return this;
    }

    public void selectFirstavailable() {
//        scrollToElement(AndroidDriveriver driver,productLocator,"up" );
//        scrollToText("Results");
        waitForElementToBePresent(By.id(productLocator), 10);
        LogUtils.INFO(" *** CLICK ON FIRST AVAILABLE PRODUCT **** ");
        click(By.id(productLocator));
    }

    public void searchResults(double items) {
        clickBackButton();
        waitForElementToBePresent(By.id(itemCountLocator), 10);
        click(By.id(itemCountLocator));
        printListOfItems(collectSearchResults(items), items);
    }

    private void printListOfItems(ArrayList<List<String>> lists, double items) {
        LogUtils.INFO("**** PRINTING LIST FOR  " + items + "  ITEMS *****");
        for (List<String> products : lists) {
            LogUtils.INFO("PRODUCT DESC & PRICE");
            for (int i = 0; i < products.size(); i++) {
                LogUtils.INFO(products.get(i));
            }
        }
    }

    public ArrayList<List<String>> collectSearchResults(double itemCount) {
        double scrollCount = 0;
        ArrayList<List<String>> searchResults;

        if (itemCount <= 3) //3 items are displayed on the screen
        {
            LogUtils.INFO(" *** ITEMS LESS THAN 3 **** ");
            searchResults = updateList(itemCount);
        } else {
            LogUtils.INFO(" *** ITEMS MORE THAN 3 **** ");
            searchResults = updateList(3);
            scrollCount = Math.ceil(itemCount / 3) - 1;
            while (scrollCount > 0) {
                LogUtils.INFO(" *** SCROLL REQUIRED **** " + scrollCount);
                scrollWithTouchAction("up", 0, 0, 280, 2324, 1); //hardcoding for device nexus 6
                searchResults = updateList(itemCount);
                scrollCount--;
            }
        }
        return searchResults;
    }

    public ArrayList<List<String>> updateList(double items) {
        int count = 0;
        List<MobileElement> itemDescription = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'textview_item_title')]"));
        List<MobileElement> itemPrice = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'textview_item_price')]"));
        while (count < itemDescription.size() && result.size() < items) {
            LogUtils.INFO(" *** Element **** " + Arrays.asList(itemDescription.get(count).getText(), itemPrice.get(count).getText()));
            result.add(Arrays.asList(itemDescription.get(count).getText(), itemPrice.get(count).getText()));
            count++;
        }
        return result;
    }
}