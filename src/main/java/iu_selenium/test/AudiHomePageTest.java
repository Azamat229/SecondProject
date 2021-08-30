package iu_selenium.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import iu_selenium.pages.HomePageObject;
//import api.pages.pages.EtsyResultsPage;
import iu_selenium.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;

public class AudiHomePageTest {
    WebDriver driver = Driver.getDriver("chrome");

    @Test
    public void userIsOnHomePage(){
        driver.get("https://www.audiusa.com/us/web/en.html");
    }

    @Test
    public void userClickSuvAndWagonsButton(){
        HomePageObject homePageObject = HomePageObject.getHomePage(driver);
        homePageObject.suvAndWagonsButton.click();
    }


}
