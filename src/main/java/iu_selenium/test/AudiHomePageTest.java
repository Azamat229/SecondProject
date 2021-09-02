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
import java.util.concurrent.TimeUnit;

public class AudiHomePageTest {
    WebDriver driver = Driver.getDriver("chrome");
    HomePageObject homePageObject = HomePageObject.getHomePage(driver);
    WebDriverWait wait = new WebDriverWait(driver, 100);


    @Test
    public void userIsOnHomePage() {
        driver.get("https://www.audiusa.com/us/web/en.html");
    }

    @Test
    public void clickSavAndWagons() {
        driver.get("https://www.audiusa.com/us/web/en.html");
        WebElement cookieButtonClick = wait.until(ExpectedConditions.visibilityOf(homePageObject.cookieSettingsButton));
        cookieButtonClick.click();
        WebElement cookieAcceptButtonClick = wait.until(ExpectedConditions.visibilityOf(homePageObject.cookieSettingsButtonAccept));
        cookieAcceptButtonClick.click();
        WebElement firstItem = wait.until(ExpectedConditions.visibilityOf(homePageObject.suvAndWagonsButton));
        firstItem.click();
    }

    @Test
    public void getAllPrices() throws InterruptedException {

        List<WebElement> secondItem = wait.until(ExpectedConditions.visibilityOfAllElements(homePageObject.suvAndWagonsList));
        WebElement elementTable;
        int ans = 0;
        for (int i = 0; i < secondItem.size(); i++) {
            elementTable = wait.until(ExpectedConditions.elementToBeClickable(secondItem.get(i)));

            elementTable.click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement ele = driver.findElement(By.tagName("h4"));
            if (ele.getText().length() > 0) {
                int num = Integer.parseInt((ele.getText().substring(13, ele.getText().length()-2)).replace(",", ""));
                ans += num;
            }

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.navigate().back();
            WebElement firstItem6 = wait.until(ExpectedConditions.elementToBeClickable(homePageObject.suvAndWagonsButton));
            driver.navigate().refresh();

            Thread.sleep(2000);
            firstItem6.click();
        }
        System.out.println(ans);

    }

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
