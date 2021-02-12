package TestMethods;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class TBaseClass {

    protected static String WebDriverURL = "http://127.0.0.1:4723/wd/hub";
    protected WebDriver driver;
    private static RequestSpecification spec;


    @BeforeSuite
    public void initTestSuite() throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        com.codeborne.selenide.Configuration.timeout = 6000;         //максимальный интервал ожидания элементов в милисекундах
        com.codeborne.selenide.Configuration.savePageSource = false;  //не сохранять дополнительные настройки
        Configuration.baseUrl = "https://checkme.kavichki.com/";
        Configuration.browser = "Chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments(Arrays.asList("--no-sandbox","--ignore-certificate-errors","--homepage=about:blank","--no-first-run"));
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(ChromeOptions.CAPABILITY, options);
        System.out.println("DateTime Start:" + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()));
        System.out.println();
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);

    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("DateTime Finish:" + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()));
    }
}
