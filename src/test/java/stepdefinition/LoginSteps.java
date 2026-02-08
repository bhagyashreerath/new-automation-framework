package stepdefinition;

import factory.DriverFactory;
import pages.LoginPage;
import io.cucumber.java.en.*;
import utils.ConfigReader;

public class LoginSteps {

    LoginPage loginPage;


    @Given("user is on Rahul Shetty page")
    public void user_on_login_page() {
        DriverFactory.getDriver()
                .get(ConfigReader.initProperties().getProperty("url"));

        loginPage = new LoginPage(DriverFactory.getDriver());
    }

    @When("user enters username and password")
    public void user_enters_credentials() {
        loginPage.login("rahul", "rahulshettyacademy");
    }

    @Then("user must login")
    public void user_logged_in() {
        // simple validation
        String title = DriverFactory.getDriver().getTitle();
        System.out.println("Page Title: " + title);


    }
}
