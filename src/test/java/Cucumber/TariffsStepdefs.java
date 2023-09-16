package Cucumber;

import Config.EnvConfig;
import UI_UXCrowd.AuthorizationPO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TariffsStepdefs {
    public static EnvConfig envConfig;
    public static AuthorizationPO authorizationPO;
    public static WebDriver driver;

    @Before
    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MINUTES);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.MINUTES);
        envConfig = new EnvConfig();

        authorizationPO = new AuthorizationPO(driver);

    }

    @Дано("Пользователь переходит на главную страницу")
    public void пользовательПереходитНаГлавнуюСтраницу() {
        driver.get(envConfig.baseUrl);
    }

    @И("Пользователь нажимает кнопку войти")
    public void ПользовательНажимаетКнопкуВойти() {
        authorizationPO.login();
    }

    @И("Пользователь вводит логин login")
    public void ПользовательВводитЛогинLogin() {
        authorizationPO.setLogin(envConfig.username);
    }

    @И("Пользователь вводит пароль password")
    public void ПользовательВводитПарольPassword() {
        authorizationPO.setPassword(envConfig.userPassword);
    }

    @И("Пользователь нажимает кнопку вход")
    public void ПользовательНажимаетКнопкуВход() {
        authorizationPO.setLogBTN();
    }

    @И("Пользователь нажимает кнопку профиль")
    public void ПользовательНажимаетКнопкуПрофиль() {
        authorizationPO.setProfileBTN();
    }

    @И("Пользователь нажимает кнопку перейти к тарифам")
    public void ПользовательНажимаетКнопкуПерейтиКТарифам() {
        authorizationPO.setGoToTariffsBTN();
    }

    @И("Пользователь нажимает кнопку изменить тариф")
    public void ПользовательНажимаетКнопкуИзменитьТариф() {
        authorizationPO.setChangeTariffToIndividBTN();
    }

    @И("Пользователь нажимает кнопку получить счет на оплату")
    public void ПользовательНажимаетКнопкуПолучитьСчетНаОплату() {
        authorizationPO.setGetInvoiceBTN();
    }

    @After
    public void driverQuit() {
        driver.close();
        driver.quit();
    }
}