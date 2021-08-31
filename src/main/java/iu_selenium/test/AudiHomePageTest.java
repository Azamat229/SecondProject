package iu_selenium.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import iu_selenium.pages.HomePageObject;
//import api.pages.pages.EtsyResultsPage;
import iu_selenium.utils.Driver;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AudiHomePageTest {
    WebDriver driver = Driver.getDriver("chrome");

    @Test
    public void userIsOnHomePage() {
        driver.get("https://www.audiusa.com/us/web/en.html");
    }

    @Test
    public void userClickSuvAndWagonsButton() throws InterruptedException {
        HomePageObject homePageObject = HomePageObject.getHomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, 100);
//        WebElement info = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).info));
//        info.click();
        WebElement cookieButtonClick = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).cookieSettingsButton));
        cookieButtonClick.click();
        WebElement cookieAcceptButtonClick = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).cookieSettingsButtonAccept));
        cookieAcceptButtonClick.click();

        WebElement firstItem = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).suvAndWagonsButton));
        firstItem.click();

        Thread.sleep(20);
        List<WebElement> secodItem = (HomePageObject.getHomePage(driver).allElements);
        int sum = 0;
        System.out.println("ALL"+secodItem);
        for (WebElement element : secodItem) {
            Thread.sleep(20);
            element.click();


        }
    }
}
