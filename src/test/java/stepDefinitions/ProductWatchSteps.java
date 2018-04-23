package stepDefinitions;


import com.pratik.appium.factory.Driver;
import com.pratik.appium.logger.LogUtils;
import com.pratik.appium.pages.*;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;

import java.util.Map;

public class ProductWatchSteps implements En {

    private AppiumDriver appiumDriver;
    private SearchResults searchResults;
    private SignIn login;
    private ProductDetails details;

    public ProductWatchSteps() {

        Given("^I search for a product \"([^\"]*)\"$", (String product) -> {
            new HomePage(appiumDriver).searchBox();
            new Search(appiumDriver).searchProduct(product);
        });

        Given("^I sort the search results by \"([^\"]*)\"$", (String sortType) -> {

            new SearchResults(appiumDriver).sortButton();
            searchResults = new SortResults(appiumDriver).selectCategory(sortType);
        });

        When("^I select the \"([^\"]*)\" available product$", (String arg1) -> {
            searchResults.selectFirstavailable();
        });

        And("^I watch the product$", () -> {
            new ProductDetails(appiumDriver).watchProduct();
        });

        And("^I enter my credentials to sign in$", (DataTable values) -> {
            Map details = values.asMaps(String.class, String.class).get(0);
            login = new SignIn(appiumDriver).enterUsername(details.get("emailId").toString());
            login = new SignIn(appiumDriver).enterPassword(details.get("password").toString());
        });

        And("^I close the sign in page$", () -> {
            login.cancel();
        });

        And("^I press back button$", () -> {
            login.clickBackButton();
        });

        And("^I want to print first \"([^\"]*)\" search results$", (Double items) -> {
            new SearchResults(appiumDriver).searchResults(items);
        });

    }


    Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        appiumDriver = Driver.getAndroidDriver();
        LogUtils.INFO("Starting scenario " + scenario.getName());
    }

    @After
    public void after(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                // Take a screenshot...
                byte[] screenshot = appiumDriver.getScreenshotAs(OutputType.BYTES);
                LogUtils.INFO("*** IN AFTER SCENARIO ***");
                scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
            }
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        LogUtils.INFO("Scenario finished" + scenario.getName());
        Driver.quitDriver();
    }
}
