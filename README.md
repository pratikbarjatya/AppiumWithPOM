# AppiumWithPOM
    This is based on Page Object Modal pattern, implementing a sample framework structure with use of Appium Driver Local Service
     and  Service Builder providing run time ip and port to launch the Appium Server.

## How to Run:
 - Run this from terminal: ./gradlew cucumber
 
 
## Output:
 - For Report: open reports/cucumber/cucumber-html-report/index.html

## Notes:
 - Code is written and tested using real/physical device (Nexus 5X - ANDROID 8.1.0)
 - Screenshot is only taken and embedded in case of failure
 - Pages does not have all the element locators
 - Improving reports in case of test failures
 - Need to Add Support for GIF/Video for every test run (success/failure) to ease debugging on CI
 - Need to Add Support for validating analytics at each test step
