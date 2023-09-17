package UI_UXCrowd;

import Config.EnvConfig;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class TestUI {
    public static AuthorizationPO authorizationPO;

    public static ChangeTariff changeTariff;
    public static FAQLink faqLink;

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static EnvConfig envConfig;
    public static PriceLink priceLink;
    public static MetricsLink metricsLink;

    @BeforeEach
    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(TestUI.driver, Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MINUTES);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        envConfig = new EnvConfig();
        driver.get(envConfig.baseUrl);
        authorizationPO = new AuthorizationPO(driver);

        changeTariff = new ChangeTariff(driver);
        faqLink = new FAQLink(driver);
        priceLink = new PriceLink(driver);
        metricsLink = new MetricsLink(driver);


    }

    @AfterEach
    public void driverQuit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void authTest() throws InterruptedException {

        authorizationPO.login();
        authorizationPO.setLogin(envConfig.username);
        authorizationPO.setPassword(envConfig.userPassword);
        authorizationPO.setLogBTN();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("sc-fzqOul")));
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(envConfig.urlClient, URL);
    }

    @Test
    public void tariff_change() throws InterruptedException {

        changeTariff.login();
        changeTariff.setLogin(envConfig.username);
        changeTariff.setPassword(envConfig.userPassword);
        changeTariff.setLogBTN();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("sc-fzqOul")));
        changeTariff.setProfileBTN();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"sc-AxiKw caLFPy\"]")));
        changeTariff.setGoToTariffsBTN();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"sc-qbCpE daKPex\"]")));
        changeTariff.setChangeTariffToIndividBTN();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"MuiPaper-root MuiDialog-paper MuiDialog-paperScrollPaper MuiDialog-paperWidthSm MuiPaper-elevation24 MuiPaper-rounded\"]")));
        changeTariff.setGetInvoiceBTN();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(envConfig.urlClientTariff, URL);
    }

    @Test
    public void FaqTest() throws InterruptedException {

        faqLink.FaqLink();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("nl-faq-header")));
        faqLink.ReadAnswer();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("nl-faq__collapse-body")));
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(envConfig.urlFAQ, URL);
    }

    @Test
    public void PriceTest() throws InterruptedException {
        priceLink.PriceLink();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("newprice-title")));
        priceLink.ChangeDuration();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("newprice-price")));
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(envConfig.urlPrice, URL);
    }

    @Test
    public void MetricsTest() throws InterruptedException {
        metricsLink.AboutLink();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("section-start__text")));
        metricsLink.MetricsLink();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("metrics-header-img")));
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(envConfig.urlMetrics, URL);
    }
}



