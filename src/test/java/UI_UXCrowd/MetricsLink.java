package UI_UXCrowd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MetricsLink {
    private WebDriver driver;
    public MetricsLink(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    @FindBy(css = "a[href=\"/about\"]")
    private WebElement clickAboutLink;

    @FindBy(css = "a[href=\"/metrics\"]")
    private WebElement clickMetrics;

    public void AboutLink(){
        clickAboutLink.click();
    }
    public void MetricsLink(){
        clickMetrics.click();
    }


}
