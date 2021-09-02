package iu_selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuildCarPageObject {
    private BuildCarPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "(//span[@class=\"audi-basket-configuration-value__label\"])[8]")
    public WebElement destCharge;

    @FindBy(xpath = "(//button)[105]")
    public WebElement closePopUp;


    @FindBy(xpath = "(//span[@class=\"audi-basket-configuration-value__label\"])[6]")
    public WebElement msrpLabel;

    @FindBy(xpath = "(//span[@class=\"audi-basket-configuration-value__label\"])[7]")
    public WebElement additionalOpt;


    @FindBy(xpath = "(//span[@class=\"nm-module-trimline-engine-price-tag\"])[1]")
    public WebElement msrpNum;

    @FindBy(xpath = "(//a[@class=\" nm-pageOpen audi-basket-button-cta audi-button audi-button--inverted\"])[1]")
    public WebElement summeryButton;



    @FindBy(xpath = "(//li[@class=\"nm-j-configurator-item nm-j-configurator-status_11000\"])[8]")
    public WebElement wheel;

    @FindBy(xpath = "(//span[@class=\"nm-j-configurator-text-price audi-copy-m\"])[14]")
    public WebElement priceOfWheel;

    @FindBy(xpath = "(//div[@class=\"audi-copy-s\"])[14]")
    public WebElement typeOfWheel;


    @FindBy(xpath = "(//div[@class=\"audi-copy-s\"])[4]")
    public WebElement nameColor;

    @FindBy(xpath = "(//button[@class=\"audi-basket__price-button-layer\"])[1]\n")
    public WebElement viewTotalPriceButton;

    @FindBy(xpath = "(//span[@class=\"nm-j-configurator-text-price audi-copy-m\"])[4]")
    public WebElement priceColorText;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/audi-configurator-tile-list[1]/div[1]/div[1]/ul[1]/li[4]/div[1]/div[1]/div[1]/img[1]")
    public WebElement priceOfColor;


    @FindBy(xpath = "//div[@class=\"nm-layer__close-button nm-j-layer-close-button\"]")
    public WebElement closeButton;

    @FindBy(xpath = "//button[@id=\"onetrust-pc-btn-handler\"]")
    public WebElement cookieSettingsButton;

    @FindBy(xpath = "//button[@class=\"save-preference-btn-handler onetrust-close-btn-handler\"]")
    public WebElement cookieSettingsButtonAccept;


    public static BuildCarPageObject getBuildPage(WebDriver driver) {
        return new BuildCarPageObject(driver);
    }

}

