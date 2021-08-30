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
        WebElement info = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).info));
        info.click();
        WebElement firstItem = wait.until(ExpectedConditions.visibilityOf(HomePageObject.getHomePage(driver).suvAndWagonsButton));
        firstItem.click();

        List<WebElement> secodItem = wait.until(ExpectedConditions.visibilityOfAllElements(HomePageObject.getHomePage(driver).suvAndWagonsList));
        int sum = 0;
        for (WebElement element : secodItem) {
            WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
            element1.click();

            try {
                String price = homePageObject.getPrice.getText();
                System.out.println(price);


            } catch (Exception e) {
                System.out.println("EXEPTION SEKA");
                System.out.println("Massage" + e.getMessage());
                System.out.println("Cause" + e.getCause());
                e.printStackTrace();

            }


            System.out.println(element.getText());

        }
//        for (WebElement element : secodItem) {
//
//            System.out.println("DEBUG iteration 1");
//            System.out.println(element);
//            element.click();
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
//        }
//        Thread.sleep();
    }


}
