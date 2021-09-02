package iu_selenium.test;

import iu_selenium.pages.BuildCarPageObject;
import iu_selenium.pages.DetailPageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import iu_selenium.pages.HomePageObject;
//import api.pages.pages.EtsyResultsPage;
import iu_selenium.utils.Driver;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class AudiHomePageTest {
    WebDriver driver = Driver.getDriver("chrome");
    WebDriverWait wait = new WebDriverWait(driver, 100);


    @org.testng.annotations.Test(priority = 1)
    public void navigateToAudioUseSite() {
        driver.get("https://www.audiusa.com/us/web/en.html");
    }

    @org.testng.annotations.Test(priority = 2)
    public void settingUpPage() {



        WebElement cookieButtonClick = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).cookieSettingsButton));
        cookieButtonClick.click();
        WebElement cookieAcceptButtonClick = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).cookieSettingsButtonAccept));
        cookieAcceptButtonClick.click();

    }


    @org.testng.annotations.Test(priority = 3)
    public void clickSUVsAndWagons() {
        WebElement firstItem = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).suvAndWagonsButton));
        firstItem.click();


    }

    @org.testng.annotations.Test(priority = 4)
    public void validateTheCarTitleAndYear() {

        WebElement q52022 = wait.until(ExpectedConditions.visibilityOf(DetailPageObject.getDetailPage(driver).q52022));

        q52022.getText();
        System.out.println("click" + q52022.getText());
        String verifyCarModel = q52022.getText().trim();
        q52022.click();

        WebElement titleQ52022 = wait.until(ExpectedConditions.visibilityOf(DetailPageObject.getDetailPage(driver).titleQ52022));

        Assertions.assertEquals(titleQ52022.getText().trim(), verifyCarModel);

    }


//Detail car page

    @Test(priority = 5)
    public void userOnDetailPage() {

        WebElement buildButtonClick = wait.until(ExpectedConditions.visibilityOf(DetailPageObject.getDetailPage(driver).buildButton));
        buildButtonClick.click();

        WebElement noticeWindowClose = wait.until(ExpectedConditions.visibilityOf(BuildCarPageObject.getBuildPage(driver).noticeWindow));
        noticeWindowClose.click();

    }

}
