package UI_UXCrowd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FAQLink {
    private WebDriver driver;
    public FAQLink(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    @FindBy(css = "a[href=\"/faq\"]")
    private WebElement clickFAQLink;

    @FindBy(css ="div[href=\"#collapse2\"]")
    private WebElement clickQuestion;

    public void FaqLink(){
        clickFAQLink.click();
    }
    public void ReadAnswer(){
        clickQuestion.click();
    }


}
