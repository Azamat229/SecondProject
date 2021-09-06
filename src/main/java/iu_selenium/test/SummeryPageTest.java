package iu_selenium.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import iu_selenium.pages.BuildCarPageObject;
import iu_selenium.pages.SummeryPageObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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

    {
        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }

    private final Logger LOG = LogManager.getLogger(BuildPageTest2.class);


    WebDriver driver = Driver.getDriver("chrome");
    WebDriverWait wait = new WebDriverWait(driver, 100);
    SummeryPageObject summaryPage = SummeryPageObject.getBuildPage(driver);
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    Actions actions = new Actions(driver);
    String msrpNum;
    WebElement msrpOnSummaryPage;



    @Then("validate if MSRP from build page is equal to MSRP from summary page")
    public void validateMSRPInSummary() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement summeryButton = BuildCarPageObject.getBuildPage(driver).summeryButton;
        summeryButton.click();

        msrpOnSummaryPage = wait.until(ExpectedConditions.visibilityOf(summaryPage.msrpPrice));

        Assertions.assertEquals(msrpNum.replace(" ", ""), msrpOnSummaryPage.getText());

        LOG.info("validated MSRP price from build page and MSRP from summary page");

    }

    @And("validate if sum of equipments is equal to {int}")
    public void validateEquipmentTotalPrice(int totalPrice) {

        int coloPrice = Integer.parseInt((summaryPage.colorPrice.getText().replace("$", "")).replace(",", ""));

        actions.moveToElement(summaryPage.elementToScroll).perform();

        int sum = coloPrice + Integer.parseInt((summaryPage.wheelsPrice.getText().replace("$", "")).replace(",", "")) + Integer.parseInt((summaryPage.airbagPrice.getText().replace("$", "")).replace(",", "")) + Integer.parseInt((summaryPage.conveniencePackagePrice.getText().replace("$", "")).replace(",", ""));

        Assertions.assertEquals(totalPrice, sum);

        LOG.info("validated sum of equipment");

    }

    @And("validate total price is {int}")
    public void validateTotalPrice(int totalPrice) {

        int coloPrice = Integer.parseInt((msrpOnSummaryPage.getText().replace("$", "")).replace(",", ""));

        actions.moveToElement(summaryPage.elementToScroll).perform();

        int sum = coloPrice + Integer.parseInt((summaryPage.totalEquipmentPrice.getText().replace("$", "")).replace(",", "")) + Integer.parseInt(((summaryPage.destinationChargePrice.getText().replace("$", "")).replace(",", "")).replace(" ", ""));

        Assertions.assertEquals(totalPrice, sum);

        LOG.info("validated total price");

    }

}
