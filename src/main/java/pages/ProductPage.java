package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ProductPage extends BasePage{
    @FindBy(xpath = "//div[@id='imgTagWrapperId']")
    private WebElement ProductImage;


    @FindBy(xpath = "//td/span[contains(@class,'apex')]/span[2]")
    private WebElement ProductBaseCurrentPrice;
    //span[contains(@class,'a-color-price hlb-')]
    @FindBy(xpath = "//div[contains(@class,'ewc-subtotal-value')]/span")
    private WebElement CartCurrentPrice;

    @FindBy(xpath = "//div[@id='availability']//span[contains(@class,'success')]")
    private WebElement inStockInscription;

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public void isVisibleProductImage() {
        ProductImage.isDisplayed();
    ProductImage.isEnabled();
    }
    public void isVisibleProductBaseCurrentPrice() {
        ProductBaseCurrentPrice.isDisplayed();
        ProductBaseCurrentPrice.isEnabled();
    }
    public String getTextCartCurrentPrice() throws InterruptedException {
        waitForPageLoadComplete(10);
        Thread.sleep(600);
        return CartCurrentPrice.getText();
    }
    public String getTextProductBaseCurrentPrice() throws InterruptedException {
        waitForPageLoadComplete(10);
        Thread.sleep(500);
        return ProductBaseCurrentPrice.getText();
    }
    public void isVisibleInStockInscription() throws InterruptedException {
        waitForPageLoadComplete(10);
        Thread.sleep(600);
        inStockInscription.isDisplayed();
        inStockInscription.isEnabled();
    }
}
