package iu_selenium.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import iu_selenium.pages.BuildCarPageObject;
import iu_selenium.pages.HomePageObject;
import iu_selenium.utils.Driver;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BuildPageTest2 {

    WebDriver driver = Driver.getDriver("chrome");
    WebDriverWait wait = new WebDriverWait(driver, 100);
    int sum = 0;
    int totalInt = 0;


//    @Test(priority = 1)
//    public void userIsOnBuildPage() {
//        driver.get("https://www.audiusa.com/us/web/en/models/q5/q5/2022/overview/build.html");
//    }


//    @Test(priority = 2)
//    public void settingUpPage() {
//
//        WebElement noticeWindowClose = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).noticeWindow));
//        noticeWindowClose.click();
//
//        WebElement cookieButtonClick = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).cookieSettingsButton));
//        cookieButtonClick.click();
//        WebElement cookieAcceptButtonClick = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).cookieSettingsButtonAccept));
//        cookieAcceptButtonClick.click();

//    }

    @When("select premium plus")
    public void selectPremiumPlus() throws InterruptedException {
        // Test case 2 - Select Premium Plus 45 TFSI
        WebElement premiumPlus = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).secondCheckBox));
        Thread.sleep(5000);
        premiumPlus.click();

    }

    @And("click view key MSRP info")
    public void clickViewKeyMSRPInfo() throws InterruptedException {
        WebElement viewKey = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).viewKeyMSRPInfo));
        viewKey.click();
    }

    @Then("validate prices")
    public void validatePrices() throws InterruptedException {
        List<WebElement> allPricePremiumPlus = wait.until(ExpectedConditions.visibilityOfAllElements(BuildCarPageObject.getBuildPage(driver).allPricesPremiumPlus));
        String[] expectedListOfPricePremiumPlus = {"$ 44,100", "$ 595", "$ 1,095"};

        for (int i = 0; i < allPricePremiumPlus.size() - 1; i++) {
            System.out.println("A:" + allPricePremiumPlus.get(i).getText().trim() + " " + expectedListOfPricePremiumPlus[i]);

            Assertions.assertEquals(allPricePremiumPlus.get(i).getText().trim(), expectedListOfPricePremiumPlus[i]);
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

        // Validate Total price is Base price + Additonal Options + Destination Charge


    }

    @And("validate total price")
    public void validateTotalPrice() throws InterruptedException {
        Assertions.assertEquals(sum, totalInt);

    }


    @And("close MSR info")
    public void closeMSRPInfo() throws InterruptedException {
        WebElement closeViewKey = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).closeViewKey));
        closeViewKey.click();
    }


}
