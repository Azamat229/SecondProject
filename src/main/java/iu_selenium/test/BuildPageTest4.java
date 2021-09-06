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

public class BuildPageTest4 {

    {
        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }

    private final Logger LOG = LogManager.getLogger(BuildPageTest2.class);

    WebDriver driver = Driver.getDriver("chrome");
    WebDriverWait wait = new WebDriverWait(driver, 1000);
    WebElement conveniencePackageButton;
    WebElement rearSideButton;
    String removeStr = "Remove";



    @When("user click add convenience package button")
    public void addConveniencePackage() {
        conveniencePackageButton = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).conveniencePackageButton));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", conveniencePackageButton);
        conveniencePackageButton.click();
        LOG.info("user click to add convenience package button");

    }

    @Then("validate remove text is displayed")
    public void validateRemoveDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        Assertions.assertEquals(conveniencePackageButton.getText(), removeStr);


        LOG.info("validate remove test is displayed");
    }

    @When("user click add rear side button")
    public void addRearSide() {

        rearSideButton = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).rearSideButton));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", rearSideButton);
        rearSideButton.click();

        LOG.info("user click to add rear side button");
    }

    @Then("validate remove text is displayed2")
    public void verifyIsSelected() throws InterruptedException {
        Thread.sleep(2000); // I tried to use other wait methods, but they didn't help

        Assertions.assertEquals(rearSideButton.getText(), removeStr);

        LOG.info("validate remove test is displayed 2");

    }

    @And("verify sum of options")
    public void verifyColor_Convenience_RearSide_Sum() {



        WebElement colorPrice = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).colorPrice));

        String colorPriceTxt = colorPrice.getText().trim().replace("$", "").replace(" ", "");
        int colorPriceInt = Integer.parseInt(colorPriceTxt);


        WebElement whilesPrice = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).wheelsPrice));

        String whilesPriceTxt = whilesPrice.getText().trim().replace("$", "");
        int whilesPriceInt = Integer.parseInt(whilesPriceTxt);



        WebElement conveniencePrice = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).conveniencePrice));
        String conveniencePriceTxt = conveniencePrice.getText().trim().replace("$", "").replace(",", "");
        int conveniencePriceInt = Integer.parseInt(conveniencePriceTxt);

        WebElement rearPrice = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).rearPrice));
        String rearPriceTxt = rearPrice.getText().trim().replace("$", "");
        int rearPriceInt = Integer.parseInt(rearPriceTxt);

        int sumPrice = colorPriceInt + conveniencePriceInt + rearPriceInt + whilesPriceInt;
        System.out.println("sumPrice"+sumPrice);
        WebElement viewKeyMSRPInfo = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).viewKeyMSRPInfo));
        viewKeyMSRPInfo.click();

        WebElement additionalOptionPrice = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).additionalOptionPrice));
        String additionalOptionPriceTxt = additionalOptionPrice.getText().trim().replace("$", "").replace(",", "");
        int additionalOptionPriceInt = Integer.parseInt(additionalOptionPriceTxt);
        System.out.println("addtional"+additionalOptionPriceInt);

        Assertions.assertEquals(sumPrice, additionalOptionPriceInt);

        LOG.info("validate sum of options");
    }

    @And("verify the total prices")
    public void verifyTotalPrice() {

        List<WebElement> allPricePremiumPlus = wait.until(ExpectedConditions.visibilityOfAllElements(BuildCarPageObject.getBuildPage(driver).allPricesPremiumPlus));
        int sum = 0;
        for (int i = 0; i < allPricePremiumPlus.size() - 1; i++) {

            String price = allPricePremiumPlus.get(i).getText().trim();
            price = price.replace(",", "").replace("$", "");
            int intPrice = Integer.parseInt(price);
            sum += intPrice;

//            System.out.println("Price" + intPrice);
        }

//        System.out.println(sum);
        String total = allPricePremiumPlus.get(allPricePremiumPlus.size() - 1).getText().trim();

        total = total.replace(",", "").replace("$", "");
        int totalInt = Integer.parseInt(total);
//        System.out.println("Total:" + totalInt);

        Assertions.assertEquals(sum, totalInt);
        WebElement closeViewKey = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).closeViewKey));
        closeViewKey.click();

        LOG.info("verify the total price");

    }
}
