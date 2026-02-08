package hooks;
import factory.DriverFactory;
import utils.ConfigReader;

import java.util.Properties;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    Properties prop;

    @Before
    public void setUp() {
        DriverFactory.initDriver(ConfigReader.getProperty("browser"));
    }
    @AfterStep
    public void afterEachStep(Scenario scenario) {

        // Screenshot after every step
        if (ConfigReader.getProperty("screenshot.on.step")
                .equalsIgnoreCase("true")) {

            byte[] screenshot =
                    ((TakesScreenshot) DriverFactory.getDriver())
                            .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Step Screenshot");
        }
    }


    @After
    public void tearDown(Scenario scenario) {

        // Screenshot only on failure
        if (ConfigReader.getProperty("screenshot.on.failure")
                .equalsIgnoreCase("true")
                && scenario.isFailed()) {

            byte[] screenshot =
                    ((TakesScreenshot) DriverFactory.getDriver())
                            .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }

        // Quit driver
        DriverFactory.quitDriver();
    }
}
