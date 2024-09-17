package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sharedData.SharedData;

public class NavigateTO extends BasePage {

    public NavigateTO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//img[@src='/assets/images/newicons/contul-meu-png.png'])[1]")
    private WebElement loginElement;


    public void navigateToLoginPage(){
        commonNeeds.clickElement(loginElement);
        LoggerUtility.info("The user accesses the login page.");

    }





}
