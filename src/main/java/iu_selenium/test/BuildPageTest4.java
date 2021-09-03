package iu_selenium.test;

import iu_selenium.pages.BuildCarPageObject;
import iu_selenium.pages.HomePageObject;
import iu_selenium.utils.Driver;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BuildPageTest4 {


    WebDriver driver = Driver.getDriver("chrome");
    WebDriverWait wait = new WebDriverWait(driver, 100);
    WebElement conveniencePackageButton;
    WebElement rearSideButton;


    @Test(priority = 1)
    public void userIsOnBuildPage() {
        driver.get("https://www.audiusa.com/us/web/en/models/q5/q5/2022/overview/build.html");
    }


    @Test(priority = 2)
    public void settingUpPage() {

        WebElement noticeWindowClose = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).noticeWindow));
        noticeWindowClose.click();

        WebElement cookieButtonClick = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).cookieSettingsButton));
        cookieButtonClick.click();
        WebElement cookieAcceptButtonClick = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).cookieSettingsButtonAccept));
        cookieAcceptButtonClick.click();

    }

    @Test(priority = 3)
    public void addConveniencePackage() {
        conveniencePackageButton = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).conveniencePackageButton));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", conveniencePackageButton);
        conveniencePackageButton.click();

    }

    @Test(priority = 4)
    public void validateRemoveDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        Assertions.assertEquals(conveniencePackageButton.getText(), "Remove"); //Verify it is selected


    }

    @Test(priority = 5)
    public void addRearSide() {

        rearSideButton = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).rearSideButton));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", rearSideButton);
        rearSideButton.click();
    }

    @Test(priority = 6)
    public void verifyIsSelected() throws InterruptedException {
        Thread.sleep(2000);

        Assertions.assertEquals(rearSideButton.getText(), "Remove"); //Verify it is selected

    }

    @Test(priority = 7)
    public void verifyColor_Convenience_RearSide_Sum() {

        WebElement colorPrice = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).colorPrice));
        String colorPriceTxt = colorPrice.getText().trim().replace("$", "").replace(" ", "");
        int colorPriceInt = Integer.parseInt(colorPriceTxt);

        WebElement conveniencePrice = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).conveniencePrice));
        String conveniencePriceTxt = conveniencePrice.getText().trim().replace("$", "").replace(",", "");
        int conveniencePriceInt = Integer.parseInt(conveniencePriceTxt);

        WebElement rearPrice = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).rearPrice));
        String rearPriceTxt = rearPrice.getText().trim().replace("$", "");
        int rearPriceInt = Integer.parseInt(rearPriceTxt);

        int sumPrice = colorPriceInt + conveniencePriceInt + rearPriceInt;
        WebElement viewKeyMSRPInfo = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).viewKeyMSRPInfo));
        viewKeyMSRPInfo.click();

        WebElement additionalOptionPrice = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).additionalOptionPrice));
        String additionalOptionPriceTxt = additionalOptionPrice.getText().trim().replace("$", "").replace(",", "");
        int additionalOptionPriceInt = Integer.parseInt(additionalOptionPriceTxt);

        Assertions.assertEquals(sumPrice, additionalOptionPriceInt);


    }

    @Test(priority = 8)
    public void verifyTotalPrice() {

        List<WebElement> allPricePremiumPlus = wait.until(ExpectedConditions.visibilityOfAllElements(BuildCarPageObject.getBuildPage(driver).allPricesPremiumPlus));
        int sum = 0;
        for (int i = 0; i < allPricePremiumPlus.size() - 1; i++) {

            String price = allPricePremiumPlus.get(i).getText().trim();
            price = price.replace(",", "").replace("$", "");
            int intPrice = Integer.parseInt(price);
            sum += intPrice;

            System.out.println("Price" + intPrice);
        }

        System.out.println(sum);
        String total = allPricePremiumPlus.get(allPricePremiumPlus.size() - 1).getText().trim();

        total = total.replace(",", "").replace("$", "");
        System.out.println("1 Total:" + total);
        int totalInt = Integer.parseInt(total);
        System.out.println("2 Total:" + totalInt);

        Assertions.assertEquals(sum, totalInt);


    }
}
