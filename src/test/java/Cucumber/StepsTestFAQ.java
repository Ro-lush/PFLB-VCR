package Cucumber;

import Config.EnvConfig;
import UI_UXCrowd.FAQLink;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class StepsTestFAQ {
    public static EnvConfig envConfig;
    public static FAQLink faqLink;
    public static WebDriver driver;

    @Before
    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MINUTES);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.MINUTES);
        envConfig = new EnvConfig();
        faqLink = new FAQLink(driver);
    }

    @Дано("Пользователь на главной странице")
    public void пользовательНаГлавнойСтранице() {
        driver.get(envConfig.baseUrl);
    }

    @И("нажимает на ссылку FAQ в меню")
    public void нажимаетНаСсылкуFAQВМеню() {
        faqLink.FaqLink();
    }

    @И("открывает содержимое ответа на нужный вопрос")
    public void открываетСодержимоеОтветаНаНужныйВопрос() {
        faqLink.ReadAnswer();
    }

    @After
    public void driverQuit() {
        driver.close();
        driver.quit();
    }
}

