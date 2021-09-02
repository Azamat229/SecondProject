package iu_selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BuildCarPageObject {
    private BuildCarPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[4]/div[2]/div/div[1]/div[2]/div[1]/div[1]/div[2]/span[2]")
    public WebElement verifyStartingPrice;

    @FindBy(xpath = "//div[@class=\"nm-module-trimline-engine-wrapper\"]")
    public WebElement boxVersionsOfCar;


    @FindAll(@FindBy(xpath = "//*[.='Starting at']//following-sibling::span"))
    public List<WebElement> allPrices;

    @FindBy(xpath = "//li[@class=\"nm-module-trimline-engine-list-item nm-j-configurator-item nm-j-configurator-status_11010\"]")
    public WebElement secondCheckBox;

    @FindBy(xpath = "//div[@class=\"audi-basket audi-basket--sticky audi-basket--desktop\"]//button[@class=\"audi-basket__price-button-layer\"]")
    public WebElement viewKeyMSRPInfo;

    @FindAll(@FindBy(xpath = "//div[@class=\"audi-basket-configuration-value audi-basket-price-details__price-value\"]//span[@class=\"audi-basket-configuration-value__label\"]"))
    public List<WebElement> allPricesPremiumPlus;

    @FindBy(xpath = "//div[@class=\"audi-basket_price-details-layer__close_button\"]//button")
    public WebElement closeViewKey;

    @FindBy(xpath = "//*[@id=\"dbad:audi:basket\"]/div/div/div/div[3]/a")
    public WebElement summary;


    @FindAll(@FindBy(xpath = "//*[.='55 TFSI e Plug-in hybrid']"))
    public List<WebElement> optionOfCar;

    @FindBy(xpath = "//*[.='Convenience package']//ancestor::div[@class=\"nm-teaser-equipment-list-item__content\"]//button")
    public WebElement conveniencePackageButton;

    @FindBy(xpath = "//*[.='Rear side thoracic airbags']//ancestor::div[@class=\"nm-teaser-equipment-list-item__content\"]//button")
    public WebElement rearSideButton;

    @FindBy(xpath = "//*[@id=\"dbad:audi:basket\"]/div/div/div/div[2]/button/span")
    public WebElement ViewKeyInfo;


    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[4]/div[2]/div/div[2]/div[20]/div/div/div[1]/a/div")
    public WebElement rearSideTitle;


    @FindBy(xpath = "//*[.='Power panoramic sunroof']")
    public WebElement powerPanoramicTitle;


    @FindBy(xpath = "//div[@class=\"nm-layer__close-button nm-j-layer-close-button\"]")
    public WebElement noticeWindow;


    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/audi-configurator-tile-list[1]/div[1]/div[1]/ul[1]/li[5]/div[1]/div[2]/div[1]/span[1]")
    public WebElement colorPrice;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[4]/div[2]/div/div[2]/div[6]/div/div/div[2]")
    public WebElement conveniencePrice;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[4]/div[2]/div/div[2]/div[20]/div/div/div[2]")
    public WebElement rearPrice;

    @FindBy(xpath = "//body/feature-app[@id='dbad:audi:basket']/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/span[2]/span[1]")
    public WebElement additionalOptionPrice;


    public static BuildCarPageObject getBuildPage(WebDriver driver) {
        return new BuildCarPageObject(driver);
    }


}
