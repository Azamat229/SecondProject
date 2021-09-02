package iu_selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class HomePageObject {

    private HomePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "//button[@id=\"onetrust-pc-btn-handler\"]")
    public WebElement cookieSettingsButton;

    @FindBy(xpath = "//button[@class=\"save-preference-btn-handler onetrust-close-btn-handler\"]")
    public WebElement cookieSettingsButtonAccept;


    @FindBy(xpath = "//*[@id=\"nm-id-content\"]/div/div[2]/audi-model-band/div[2]/div[2]/div[1]/ul/li[1]/label[1]")
    public WebElement suvAndWagonsButton;

    @FindAll(@FindBy(xpath = "//li[@class=\"nm-model-band-container-item nm-model-band-container-types-item0 nm-model-band-container-item-visible\"]//ul[@class=\"nm-model-band-container-item-list\"]//li"))
    public List<WebElement> suvAndWagonsList;






    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }



}
