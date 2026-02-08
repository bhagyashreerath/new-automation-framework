package stepdefinition;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.VisitUsPage;
import utils.ConfigReader;

public class VisitUsSteps {
    VisitUsPage visitUsPage;
    @Given("user is on login page")
        public void user_on_login_page(){
        DriverFactory.getDriver().get(ConfigReader.initProperties().getProperty("url"));
        visitUsPage = new VisitUsPage(DriverFactory.getDriver());

    }
    @When("user clicks on Visit Us button")
        public void user_clicks_visitUs(){
        visitUsPage.navigateToVisitUs();
    }
    @Then("user lands on Visit Us page")
        public void visitUs_open(){
        String title = DriverFactory.getDriver().getTitle();
        System.out.println("Page Title: " + title);
    }
}
