package iu_selenium.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import iu_selenium.pages.BuildCarPageObject;
import iu_selenium.utils.Driver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class BuildPageTest2 {

    {
        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }

    private final Logger LOG = LogManager.getLogger(BuildPageTest2.class);


    WebDriver driver = Driver.getDriver("chrome");
    WebDriverWait wait = new WebDriverWait(driver, 100);
    int sum = 0;
    int totalInt = 0;


    @When("select premium plus")
    public void selectPremiumPlus() {
        // Test case 2 - Select Premium Plus 45 TFSI
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement premiumPlus = BuildCarPageObject.getBuildPage(driver).secondCheckBox;
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", premiumPlus);

        premiumPlus.click();

        LOG.info("user selected premium plus");


    }

    @And("click view key MSRP info")
    public void clickViewKeyMSRPInfo() {
        WebElement viewKey = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).viewKeyMSRPInfo));
        viewKey.click();

        LOG.info("user clicked MSRP info");

    }

    @Then("validate prices of {string}, {string}, {string}")
    public void validatePrices(String p1, String p2, String p3) {
        List<WebElement> allPricePremiumPlus = wait.until(ExpectedConditions.visibilityOfAllElements(BuildCarPageObject.getBuildPage(driver).allPricesPremiumPlus));
        System.out.println(p1 + " " + p2 + " " + p3);
        String[] allPrices = {p1, p2, p3};

        for (int i = 0; i < allPricePremiumPlus.size() - 1; i++) {
            System.out.println("A:" + allPricePremiumPlus.get(i).getText().trim() + " " + allPrices[i]);

            Assertions.assertEquals(allPricePremiumPlus.get(i).getText().trim(), allPrices[i]);
            String price = allPricePremiumPlus.get(i).getText().trim();
            price = price.substring(2, price.length());
            price = price.replace(",", "");
            int intPrice = Integer.parseInt(price);
            sum += intPrice;

            System.out.println("Price" + intPrice);
        }

        System.out.println(sum);
        String total = allPricePremiumPlus.get(allPricePremiumPlus.size() - 1).getText().trim();

        total = total.replace(",", "").replace("$", "").replace(" ", "");
        totalInt = Integer.parseInt(total);
        System.out.println("2 Total:" + totalInt);

        LOG.info("validated prices");


    }

    @And("validate total price")
    public void validateTotalPrice() throws InterruptedException {
        Assertions.assertEquals(sum, totalInt);

        LOG.info("validated total price");

    }


    @And("close MSR info")
    public void closeMSRPInfo() throws InterruptedException {
        WebElement closeViewKey = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).closeViewKey));
        closeViewKey.click();

        LOG.info("user closed MSRP info");

    }


}
