package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Create driver
    public static void initDriver(String browser) {

        if(browser.equalsIgnoreCase("chrome")){

            ChromeOptions options = new ChromeOptions();

            if(ConfigReader.initProperties()
                    .getProperty("headless")
                    .equalsIgnoreCase("true")) {

                options.addArguments("--headless");
            }

            driver.set(new ChromeDriver(options));
        }

        else if (browser.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());
        }
        else if (browser.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
        }
        else {
            throw new RuntimeException("Invalid browser: " + browser);
        }

        getDriver().manage().window().maximize();
    }

    // Get driver
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Quit driver
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
