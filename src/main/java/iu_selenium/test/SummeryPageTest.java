package iu_selenium.test;

import iu_selenium.pages.BuildCarPageObject;
import iu_selenium.pages.SummeryPageObject;
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

public class SummeryPageTest {

    WebDriver driver = Driver.getDriver("chrome");
    WebDriverWait wait = new WebDriverWait(driver, 100);
    SummeryPageObject summaryPage = SummeryPageObject.getBuildPage(driver);
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    Actions actions = new Actions(driver);
    String msrpNum;
    WebElement msrpOnSummaryPage;

    @Test (priority = 1)
    public void userIsOnHomePage() throws InterruptedException {
        driver.get("https://www.audiusa.com/us/web/en/models/q5/q5/2022/overview/build.html#");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement num = BuildCarPageObject.getBuildPage(driver).msrpNum;
        msrpNum = num.getText();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement closeButton = BuildCarPageObject.getBuildPage(driver).closeButton;

        closeButton.click();

        WebElement cookieButtonClick = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).cookieSettingsButton));
        cookieButtonClick.click();
        WebElement cookieAcceptButtonClick = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).cookieSettingsButtonAccept));
        cookieAcceptButtonClick.click();

        BuildCarPageObject object = BuildCarPageObject.getBuildPage(driver);
        WebElement wheel = wait.until(ExpectedConditions.visibilityOf(object.wheel));
        WebElement color = wait.until(ExpectedConditions.visibilityOf(object.priceOfColor));

        actions.moveToElement(wheel).perform();
        Thread.sleep(1000);

        color.click();
        Thread.sleep(1000);

        jse.executeScript("arguments[0].scrollIntoView();", color);
        Thread.sleep(2000);

        wheel.click();
        Thread.sleep(1000);

        WebElement conveniencePackageButton = SummeryPageObject.getBuildPage(driver).conveniencePackageButton;
        actions.moveToElement(SummeryPageObject.getBuildPage(driver).rearSideTitle);
        Thread.sleep(100);
        actions.perform();
        conveniencePackageButton.click();
        Thread.sleep(3000);
        Assertions.assertEquals(conveniencePackageButton.getText(), "Remove"); //Verify it is selected


        WebElement rearSideButton = SummeryPageObject.getBuildPage(driver).rearSideButton;
        actions.moveToElement(SummeryPageObject.getBuildPage(driver).powerPanoramicTitle);
        Thread.sleep(100);
        actions.perform();
        rearSideButton.click();
        Thread.sleep(3000);

    }

    @Test (priority = 2)
    public void validateMSRPInSummary() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        WebElement summeryButton = BuildCarPageObject.getBuildPage(driver).summeryButton;
        summeryButton.click();

        msrpOnSummaryPage = wait.until(ExpectedConditions.visibilityOf(summaryPage.msrpPrice));


        Assertions.assertEquals(msrpNum.replace(" ", ""), msrpOnSummaryPage.getText());

    }

    @Test (priority = 3)
    public void validateEquipmentTotalPrice() {

        int coloPrice = Integer.parseInt((summaryPage.colorPrice.getText().replace("$", "")).replace(",", ""));

        actions.moveToElement(summaryPage.elementToScroll).perform();

        int sum = coloPrice + Integer.parseInt((summaryPage.wheelsPrice.getText().replace("$", "")).replace(",", "")) + Integer.parseInt((summaryPage.airbagPrice.getText().replace("$", "")).replace(",", "")) + Integer.parseInt((summaryPage.conveniencePackagePrice.getText().replace("$", "")).replace(",", ""));


        Assertions.assertEquals(2845, sum);


    }

    @Test (priority = 4)
    public void validateTotalPrice() {

        int coloPrice = Integer.parseInt((msrpOnSummaryPage.getText().replace("$", "")).replace(",", ""));

        actions.moveToElement(summaryPage.elementToScroll).perform();

        int sum = coloPrice + Integer.parseInt((summaryPage.totalEquipmentPrice.getText().replace("$", "")).replace(",", "")) + Integer.parseInt(((summaryPage.destinationChargePrice.getText().replace("$", "")).replace(",", "")).replace(" ", ""));

        Assertions.assertEquals(48040, sum);

    }

}
