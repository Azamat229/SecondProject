package iu_selenium.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import iu_selenium.pages.DetailPageObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import iu_selenium.pages.HomePageObject;
import iu_selenium.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AudiHomePageTest {
    {
        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }

    private final Logger LOG = LogManager.getLogger(AudiHomePageTest.class);


    WebDriver driver = Driver.getDriver("chrome");
    HomePageObject homePageObject = HomePageObject.getHomePage(driver);
    WebDriverWait wait = new WebDriverWait(driver, 100);


    @Given("user is on etsy home page")
    public void userIsOnHomePage() {
        driver.get("https://www.audiusa.com/us/web/en.html");
        LOG.info("user on home page");

    }


    @When("user click sav and wagons")
    public void clickSavAndWagons() {
        WebElement cookieButtonClick = wait.until(ExpectedConditions.visibilityOf(homePageObject.cookieSettingsButton));
        cookieButtonClick.click();
        WebElement cookieAcceptButtonClick = wait.until(ExpectedConditions.visibilityOf(homePageObject.cookieSettingsButtonAccept));
        cookieAcceptButtonClick.click();
        WebElement firstItem = wait.until(ExpectedConditions.visibilityOf(homePageObject.suvAndWagonsButton));
        firstItem.click();

        LOG.info("user clicked on cars button SAV and Wagons");

    }


    @Then("user get all prices")
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
        LOG.info("got all prices");


    }





    @When("user select SUVs and Wagons")
    public void clickSUVsAndWagons() {
        WebElement cookieButtonClick = wait.until(ExpectedConditions.visibilityOf(homePageObject.cookieSettingsButton));
        cookieButtonClick.click();
        WebElement cookieAcceptButtonClick = wait.until(ExpectedConditions.visibilityOf(homePageObject.cookieSettingsButtonAccept));
        cookieAcceptButtonClick.click();
        WebElement firstItem = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).suvAndWagonsButton));
        firstItem.click();

        LOG.info("user clicked Audi Q5");

    }

    @Then("user validate the car title and year")
    public void validateTheCarTitleAndYear() {

        WebElement q52022 = wait.until(ExpectedConditions.visibilityOf(DetailPageObject.getDetailPage(driver).q52022));

        q52022.getText();
        System.out.println("click" + q52022.getText());
        String verifyCarModel = q52022.getText().trim();
        q52022.click();

        WebElement titleQ52022 = wait.until(ExpectedConditions.visibilityOf(DetailPageObject.getDetailPage(driver).titleQ52022));

        Assertions.assertEquals(titleQ52022.getText().trim(), verifyCarModel);

        LOG.info("validated the car title and year");

    }

}
