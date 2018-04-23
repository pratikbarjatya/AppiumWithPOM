package com.pratik.appium.pages;

import com.pratik.appium.logger.LogUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class SortResults extends BasePage {

    public SortResults(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        LogUtils.INFO("Instantiated " + SortResults.class.getName());
    }

    private String doneButtonLocator = "button_done";

    @AndroidFindBy(className = "android.widget.ListView")
    private MobileElement sortType;

    public final List<MobileElement> getFilters() {
        return sortType.findElementsByClassName("android.widget.CheckedTextView");
    }

    public SearchResults selectCategory(String category) {
        LogUtils.INFO(" *** SORTING RESULTS BY: **** " + category);
        waitForElementToBePresent(By.id(doneButtonLocator), 5);
        for (MobileElement element : getFilters()) {
            if (element.getText().contains(category)) {
                LogUtils.INFO("*** CLICKED ON FILTER ***" + element.getText());
                element.click();
                break;
            }

        }
        return new SearchResults(driver);
    }


}

