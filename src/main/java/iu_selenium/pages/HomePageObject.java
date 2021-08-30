package iu_selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class HomePageObject {

    private HomePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//button[@class=\"onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon\"]")
    public WebElement info;

    @FindBy(xpath = "//*[@id=\"nm-id-content\"]/div/div[2]/audi-model-band/div[2]/div[2]/div[1]/ul/li[1]/label[1]")
    public WebElement suvAndWagonsButton;
    ////*[@id="nm-id-content"]/div/div[2]/audi-model-band/div[2]/div[2]/div[1]/ul/li[1]/label[1]/picture[1]/img


    @FindBy(xpath = "//*[@id=\"nm-id-content\"]/div/div[2]/audi-model-band/div[3]/ul[2]/li[1]/div/ul")
    // //*[@id="nm-id-content"]/div/div[2]/audi-model-band/div[3]/ul[2]/li[1]/div/ul
    public List<WebElement> suvAndWagonsList;

//    @FindBy(xpath = "//h4[@class=\"sc-fzoWqW hXeTQQ\"]//span[@class=\"sc-hOspLL enDSVW\"]")
//    public WebElement getPrice;

    @FindBy(xpath = "//*[@id=\"audi:stage-large-feature-app:b7d0ecb9\"]/div/div/div/div[1]/div[2]/div/div/div[1]/div[2]/h4/span")
    public WebElement getPrice;








    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }


}
