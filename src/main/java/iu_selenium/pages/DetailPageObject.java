package iu_selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailPageObject {


    private DetailPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"nm-id-content\"]/div/div[2]/audi-model-band/div[3]/ul[2]/li[1]/div/ul/li[4]")
    public WebElement q52022;

    @FindBy(xpath = "//*[@id=\"audi:stage-large-feature-app:2453c579\"]/div/div/div/div/div[3]/div/div/div[1]/div[1]/h1/span")
    public WebElement titleQ52022;

    @FindBy(xpath = "//*[@id=\"audi:stage-large-feature-app:2453c579\"]/div/div/div/div/div[3]/div/div/div[2]/a[1]")
    public WebElement buildButton;

    public static DetailPageObject getDetailPage(WebDriver driver) {
        return new DetailPageObject(driver);
    }


}

