package com.pratik.appium.listeners;

import com.pratik.appium.logger.LogUtils;
import io.appium.java_client.events.api.general.ElementEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementListener implements ElementEventListener {

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        LogUtils.INFO("Clicking on " + element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        LogUtils.INFO("Clicked on " + element);

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }
}
