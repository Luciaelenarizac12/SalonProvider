package pages;

import helpers.CommonNeeds;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected CommonNeeds commonNeeds;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.commonNeeds = new CommonNeeds(driver);
        PageFactory.initElements(driver, this);
    }
}
