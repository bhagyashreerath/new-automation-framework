package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VisitUsPage {
    WebDriver driver;
    private By visitUsBtn= By.id("visitUsTwo");
    public VisitUsPage(WebDriver driver){
        this.driver=driver;
    }
    public void navigateToVisitUs(){
        driver.findElement(visitUsBtn).click();
    }

}
