package exitoStore.utils;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class DriverManager {

    public static String getBrowser() {
        String[] drivers = {"chrome"};
        int value = Faker.instance().random().nextInt(drivers.length);
        return drivers[value];
    }

    public static WebDriver getWebDriver(String browser) {
        WebDriver webDriver;

        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito --disable-popup-blocking --disable-download-notification" +
                        "  --disable-notification --start-maximized --test-type,ignore-certificate-errors" +
                        "  --allow-running-insecure-content --disable-translate --always-authorize-plugins" +
                        "  --disable-extensions --disable-dev-shm-usage --disable-notifications");
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                webDriver = new FirefoxDriver();
                break;
            case "edge":
                webDriver = new EdgeDriver();
                break;
            default:
                log.error("The browser is invalid");
                return null;
        }

        webDriver.manage().window().maximize();
        return webDriver;
    }
}