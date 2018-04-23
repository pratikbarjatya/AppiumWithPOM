package com.pratik.appium.pages;

import com.pratik.appium.commons.ScrollDirection;
import com.pratik.appium.logger.LogUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;
    public int height, width;


    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        LogUtils.INFO("Instantiated " + BasePage.class.getName());
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        //TODO initialize utility
        height = (height == 0) ? driver.manage().window().getSize().height : height;
        width = (width == 0) ? driver.manage().window().getSize().width : width;
    }

    protected void click(By byLocator) {
        LogUtils.INFO("Click on - " + byLocator.toString());
        driver.findElement(byLocator).click();
    }

    private boolean isElementPresent(By by) {
        LogUtils.INFO("Is element Present? (WebElement) - " + by.toString());
        try {
            driver.findElement(by);
            LogUtils.INFO("Element Present (By) - " + by.toString());
            return true;
        } catch (NoSuchElementException e) {
            LogUtils.INFO("Element - " + by.toString() + " - NOT Present. NoSuchElementException - '" + e.getMessage() + "'\n\tReturning isElementPresent - false");
            return false;
        } catch (Exception e) {
            LogUtils.INFO("Element - " + by.toString() + " - NOT Present. Exception - '" + e.getMessage() + "'\n\tReturning isElementPresent - false");
            return false;
        }
    }

    protected boolean waitForElementToBePresent(By by, int timeout) {
        try {
            LogUtils.INFO("Wait for element - '" + by.toString() + "' to be present. Timeout - " + timeout);
            wait = new WebDriverWait(driver, timeout);//120
            Boolean isPresent = wait.until((ExpectedCondition<Boolean>) driver -> isElementPresent(by));
            LogUtils.INFO("androidElement  - '" + by.toString() + " - is Present? - " + isPresent);
            return isPresent;
        } catch (NoSuchElementException | TimeoutException ex) {
            return logErrorTakeScreenshotAndReturnFalse("waitForElementToBePresent", ex);
        }
    }

    public void scrollWithTouchAction(String direction, int x1, int x2, int y1, int y2, int time) {
        TouchAction touchAction = new TouchAction(driver);
        int startX = x1;
        int startY = y1;
        int endX = x2;
        int endY = y2;

        for (int i = 0; i < time; i++) {
            if (direction.equals(ScrollDirection.DOWN)) {
                touchAction.press(x1, y1).moveTo(0, -y2).perform();
            } else if (direction.equals(ScrollDirection.UP)) {
                LogUtils.INFO("*** SCROLLING ***");
                touchAction.press(x2, y2).waitAction(Duration.ofSeconds(8)).moveTo(x1, y1).release().perform();
            }
            try {
                Thread.sleep(200); //sleep between scroll
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void clickBackButton() {
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }


    private boolean logErrorTakeScreenshotAndReturnFalse(String fromMethod, Exception ex) {
        LogUtils.ERROR("ERROR - " + ex.getMessage() + "\n" + ex);
        return false;
    }


}
