package UI_UXCrowd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriceLink {
    private WebDriver driver;
    public PriceLink(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    @FindBy(css = "a[href=\"/price\"]")
    private WebElement clickPriceLink;

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[2]/div[1]/div[3]")
    private WebElement clickYear;

    public void PriceLink(){
        clickPriceLink.click();
    }
    public void ChangeDuration(){
        clickYear.click();
    }


}
