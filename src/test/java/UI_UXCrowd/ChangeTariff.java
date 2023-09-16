package UI_UXCrowd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeTariff {
    private WebDriver driver;


    public ChangeTariff(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(css = "#header-lk-button")
    private WebElement clikcBTN;
    @FindBy(xpath = "//*[@id=\"login\"]")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"form_auth\"]/input[2]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"form_auth\"]/button")
    private WebElement logBTN;

    @FindBy(xpath = "//*[@data-testid=\"Profile client menu button\"]")
    private WebElement profileBTN;

    @FindBy(xpath = "//*[@class=\"sc-qYIQh btCmFj\"]")
    private WebElement goToTariffsBTN;

    @FindBy(xpath = "//*[@class=\"sc-qYIQh jrVKaK\"]")
    private WebElement changeTariffToIndividBTN;

    @FindBy(xpath = "//*[@class=\"sc-qYIQh kzeueZ\"]")
    private WebElement getInvoiceBTN;

    public void login(){
        clikcBTN.click();
    }
    public void setLogin(String loginClient){
        login.sendKeys(loginClient);
    }
    public void setPassword(String passw){
        password.sendKeys(passw);
    }
    public void setLogBTN(){
        logBTN.click();
    }
    public void setProfileBTN(){profileBTN.click();}
    public void setGoToTariffsBTN(){goToTariffsBTN.click();}
    public void setChangeTariffToIndividBTN(){changeTariffToIndividBTN.click();}
    public void setGetInvoiceBTN(){getInvoiceBTN.click();}
}
