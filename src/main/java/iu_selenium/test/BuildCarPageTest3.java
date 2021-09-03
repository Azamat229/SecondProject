package iu_selenium.test;

import iu_selenium.pages.BuildCarPageObject;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import iu_selenium.pages.HomePageObject;
//import api.pages.pages.EtsyResultsPage;
import iu_selenium.utils.Driver;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import static org.testng.TestRunner.PriorityWeight.priority;


public class BuildCarPageTest3 {
    WebDriver driver = Driver.getDriver("chrome");
    WebDriverWait wait = new WebDriverWait(driver, 100);
    BuildCarPageObject buildPage = BuildCarPageObject.getBuildPage(driver);
    JavascriptExecutor jse = (JavascriptExecutor)driver;


    @Test (priority = 1)
    public void userIsOnHomePage() {
        driver.get("https://www.audiusa.com/us/web/en/models/q5/q5/2022/overview/build.html#");
    }

    @Test (priority = 2)
    public void highlightColorPicker() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement closeButton = buildPage.closeButton;


        closeButton.click();

        WebElement cookieButtonClick = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).cookieSettingsButton));
        cookieButtonClick.click();
        WebElement cookieAcceptButtonClick = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).cookieSettingsButtonAccept));
        cookieAcceptButtonClick.click();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Actions action = new Actions(driver);
        action.moveToElement(buildPage.wheel).perform();

        action.moveToElement(buildPage.priceOfColor).perform();
    }

    @Test (priority = 3)
    public void validateColorName() {
        WebElement nameOfColor = wait.until(ExpectedConditions.visibilityOf(buildPage.nameColor));
        WebElement priceOfColorText = wait.until(ExpectedConditions.visibilityOf(buildPage.priceColorText));

        Assertions.assertEquals("District Green metallic", nameOfColor.getText());
        Assertions.assertEquals("$ 595", priceOfColorText.getText());
    }

    @Test (priority = 4)
    public void validateExteriorColor() {
        buildPage.priceOfColor.click();
    }

    @Test (priority = 5)
    public  void validateTotalPrice() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        buildPage.viewTotalPriceButton.click();

        WebElement msrp = wait.until(ExpectedConditions.visibilityOf(buildPage.msrpLabel));

        int sum = Integer.parseInt((((msrp.getText()).replace("$", "")).replace(",", "")).replace(" ", "")) + Integer.parseInt((((buildPage.additionalOpt.getText()).replace("$", "")).replace(",", "")).replace(" ", "")) + Integer.parseInt((((buildPage.destCharge.getText()).replace("$", "")).replace(",", "")).replace(" ", ""));

        Assertions.assertEquals(sum, 45790);
    }

    @Test (priority = 6)
    public  void click19Wheel() {
        WebElement butClose = buildPage.closePopUp;
        butClose.click();

        jse.executeScript("arguments[0].scrollIntoView();", buildPage.priceOfColor);

        buildPage.wheel.click();
    }

    @Test (priority = 7)
    public void validateWheel() {
        WebElement type = wait.until(ExpectedConditions.visibilityOf(buildPage.typeOfWheel));
        WebElement price = wait.until(ExpectedConditions.visibilityOf(buildPage.priceOfWheel));
        String wheelInfo = type.getText() + " " + price.getText();
        Assertions.assertEquals("19\" 5-double-arm design wheels, bi-color finish, with all-season tires $800", wheelInfo);
    }

}
