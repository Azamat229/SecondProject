package iu_selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageObject {

    private HomePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[@for=\"nm-model-band-441412-types-0\"]")
    public WebElement suvAndWagonsButton;


    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }


}
