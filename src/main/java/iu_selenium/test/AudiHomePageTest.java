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

import java.util.List;

public class AudiHomePageTest {
    WebDriver driver = Driver.getDriver("chrome");

    @Test
    public void userIsOnHomePage() {
        driver.get("https://www.audiusa.com/us/web/en.html");
    }

    @Test
    public void userClickSuvAndWagonsButton() {
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

        List<WebElement> secodItem = wait.until(ExpectedConditions.visibilityOfAllElements(HomePageObject.getHomePage(driver).suvAndWagonsList));
        System.out.println(secodItem);
        System.out.println(secodItem.size());
        for (WebElement element : secodItem) {

            System.out.println("DEBUG iteration 1");
            String name = String.format("%s", element.getText());
//            System.out.println(name);
            WebElement w = driver.findElement(By.xpath("//li[@class=\"nm-model-band-container-item nm-model-band-container-types-item0 nm-model-band-container-item-visible\"]//ul[@class=\"nm-model-band-container-item-list\"]//li"));
            System.out.println(w.getText());
            w.click();
//            String price = homePageObject.getPrice.getText();
//            if (price == null){
//                System.out.println("No element ");
//            }else{
//                System.out.println(price);
//            }
//
//
//
//        }


//        for (int i = 0; i <= suvAndWagonsList.size() - 1; i++) {
//            double newDollar = Double.parseDouble(dollar.get(i).getText());
//            double newCent = Double.parseDouble(cent.get(i).getText());
//            ans += newDollar + (newCent / 100);
//
        }


    }
}
