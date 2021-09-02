package iu_selenium.test;

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

public class BuildPageTest1 {
    WebDriver driver = Driver.getDriver("chrome");
    WebDriverWait wait = new WebDriverWait(driver, 100);

    @Test(priority = 1)
    public void userIsOnHomePage() {
        driver.get("https://www.audiusa.com/us/web/en/models/q5/q5/2022/overview/build.html#");
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
    public void validateStartPrice() throws InterruptedException {
        WebElement verifyStartingPrice = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).verifyStartingPrice));
        String verifyStartingPriceStr = verifyStartingPrice.getText().trim();
        String expectedPrice = "$ 44,100";
        System.out.println(verifyStartingPriceStr.substring(2) + " " + expectedPrice);
        Assertions.assertEquals(verifyStartingPriceStr, expectedPrice);

    }

    @Test(priority = 4)
    public void validateThreeVersionCar() {

        WebElement boxVersionsOfCar = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).boxVersionsOfCar));
        String amountOfVersion = boxVersionsOfCar.getAttribute("data-trimline-counter");
        System.out.println(amountOfVersion + " " + "3");
        Assertions.assertEquals(amountOfVersion, "3");

    }

    @Test(priority = 5)
    public void validatePremiumPrices() {

        List<WebElement> firstPrice = wait.until(ExpectedConditions.visibilityOfAllElements(BuildCarPageObject.getBuildPage(driver).allPrices));
        String[] expectedListOfPrice = {"44,100", "49,100", "54,800"};
        for (int i = 0; i < firstPrice.size(); i++) {
            String firstPrice1 = firstPrice.get(i).getText().trim();
            String firstPrice1Clear = firstPrice1.replace("$", "").replace(" ", "");

            System.out.println(firstPrice1Clear + " " + expectedListOfPrice[i]);

            Assertions.assertEquals(firstPrice1Clear, expectedListOfPrice[i]);

        }
    }

    @Test(priority = 6)
    public void validateThreeVersionHasDifOptions() {

        // 55 TFSI® e Plug-in hybrid
        List<WebElement> optionOfCar = wait.until(ExpectedConditions.visibilityOfAllElements(BuildCarPageObject.getBuildPage(driver).optionOfCar));
        int sizeOption = optionOfCar.size();
        Assertions.assertEquals(sizeOption, 3);// изменить
    }


}
