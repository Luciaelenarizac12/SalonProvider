package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookiesPage extends BasePage {


    public CookiesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='CybotCookiebotDialogBodyButtonsWrapper']/button[text()='Permite toate']")
    private WebElement cookieHome;


    public void closeCookies(){
        commonNeeds.clickJSElement(cookieHome);
        LoggerUtility.info("The user closes the cookies - that means they exist.");
    }
}
