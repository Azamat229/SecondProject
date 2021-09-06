package iu_selenium.test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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



    @When("user highlights color")
    public void highlightColorPicker() {

        Actions action = new Actions(driver);
        action.moveToElement(buildPage.wheel).perform();

        action.moveToElement(buildPage.priceOfColor).perform();
    }

    @Then("validate if color name is {string}, and price is {string}")
    public void validateColorName(String colorName, String priceOfColor) {
        WebElement nameOfColor = wait.until(ExpectedConditions.visibilityOf(buildPage.nameColor));
        WebElement priceOfColorText = wait.until(ExpectedConditions.visibilityOf(buildPage.priceColorText));

        Assertions.assertEquals(colorName, nameOfColor.getText());
        Assertions.assertEquals(priceOfColor, priceOfColorText.getText());
    }

    @When("user clicks green color")
    public void validateExteriorColor() {
        buildPage.priceOfColor.click();
    }

    @Then("validate if total sum is equal to {int}")
    public void validateTotalPrice(int num) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        buildPage.viewTotalPriceButton.click();

        WebElement msrp = wait.until(ExpectedConditions.visibilityOf(buildPage.msrpLabel));

        int sum = Integer.parseInt((((msrp.getText()).replace("$", "")).replace(",", "")).replace(" ", "")) + Integer.parseInt((((buildPage.additionalOpt.getText()).replace("$", "")).replace(",", "")).replace(" ", "")) + Integer.parseInt((((buildPage.destCharge.getText()).replace("$", "")).replace(",", "")).replace(" ", ""));

        Assertions.assertEquals(sum, num);
    }

    @When("user chooses wheel")
    public  void click19Wheel() {
        WebElement butClose = buildPage.closePopUp;
        butClose.click();

        jse.executeScript("arguments[0].scrollIntoView();", buildPage.priceOfColor);

        buildPage.wheel.click();
    }

    @Then("validate if the text on wheel label is equal to {string}")
    public void validateWheel(String nameOfWheel) {
        WebElement type = wait.until(ExpectedConditions.visibilityOf(buildPage.typeOfWheel));
        WebElement price = wait.until(ExpectedConditions.visibilityOf(buildPage.priceOfWheel));
        String wheelInfo = type.getText() + " " + price.getText();
        Assertions.assertEquals(nameOfWheel, wheelInfo);
    }

}
