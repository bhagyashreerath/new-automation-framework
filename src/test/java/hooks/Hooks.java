package hooks;

import factory.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;

import java.util.Properties;

public class Hooks {

    Properties prop;

    @Before
    public void setup() {
        prop = ConfigReader.initProperties();
        DriverFactory.initDriver(prop.getProperty("browser"));
    }

    @AfterStep
    public void afterEachStep(Scenario scenario) {

        if (prop.getProperty("screenshot.on.step")
                .equalsIgnoreCase("true")) {

            byte[] screenshot =
                    ((TakesScreenshot)DriverFactory.getDriver())
                            .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot,"image/png","Step Screenshot");
        }
    }

    @After
    public void tearDown(Scenario scenario) {

        if (prop.getProperty("screenshot.on.failure")
                .equalsIgnoreCase("true")
                && scenario.isFailed()
        ) {

            byte[] screenshot =
                    ((TakesScreenshot)DriverFactory.getDriver())
                            .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot,"image/png","Failure Screenshot");
        }

        DriverFactory.quitDriver();
    }
}
