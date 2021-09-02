package iu_selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummeryPageObject {

    private SummeryPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[.='Convenience package']//ancestor::div[@class=\"nm-teaser-equipment-list-item__content\"]//button")
    public WebElement conveniencePackageButton;

    @FindBy(xpath = "//*[.='Rear side thoracic airbags']//ancestor::div[@class=\"nm-teaser-equipment-list-item__content\"]//button")
    public WebElement rearSideButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[4]/div[2]/div/div[2]/div[20]/div/div/div[1]/a/div")
    public WebElement rearSideTitle;

    @FindBy(xpath = "//*[.='Power panoramic sunroof']")
    public WebElement powerPanoramicTitle;


    //Summary class
    @FindBy(xpath = "(//span[@class=\"js-configurator-model-text-price\"])[1]")
    public WebElement msrpPrice;

    @FindBy(xpath = "(//span[@class=\"nm-j-configurator-text-price\"])[4]")
    public WebElement colorPrice;

    @FindBy(xpath = "(//span[@class=\"nm-j-configurator-text-price\"])[13]")
    public WebElement wheelsPrice;

    @FindBy(xpath = "(//span[@class=\"nm-j-configurator-text-price\"])[44]")
    public WebElement airbagPrice;

    @FindBy(xpath = "(//span[@class=\"nm-j-configurator-text-price\"])[91]")
    public WebElement conveniencePackagePrice;

    @FindBy(xpath = "(//span[@class=\"nm-summary-options-total__value audi-copy-m nm-j-configurator-text-optionsPrice\"])")
    public WebElement totalEquipmentPrice;

    @FindBy(xpath = "(//span[@class=\"nm-summary-options-total__value audi-headline-order-3 nm-j-configurator-text-totalWithCharges\"])")
    public WebElement elementToScroll;


    @FindBy(xpath = "(//span[@class=\"nm-summary-options-total__value audi-copy-m\"])")
    public WebElement destinationChargePrice;




    public static SummeryPageObject getBuildPage(WebDriver driver) {
        return new SummeryPageObject(driver);
    }
}
