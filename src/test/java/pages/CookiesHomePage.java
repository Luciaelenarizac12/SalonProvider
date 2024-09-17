package pages;

import helpers.CommonNeeds;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiesHomePage {

    private WebDriver driver;


    @FindBy(xpath = "//div[@id='CybotCookiebotDialogBodyButtonsWrapper']/button[text()='Permite toate']")
    private WebElement cookieHome;

    private CookiesHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //nu mosteneste BasePage, deci are nevoie de PageFactory pentru a initializa elementele definite cu adnotarea @FindBy
    }

    private static CookiesHomePage instance;  //IMPLEMENTAM DESIGN PATTERN UL SINGLETON -> pastreaza instanta unica a clasei (controlam utilizarea resurselor)

    public static synchronized CookiesHomePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new CookiesHomePage(driver);
        }
        return instance;
    }


    public void cookieForHomePage() {
        new CommonNeeds(driver).clickElement(cookieHome);
        LoggerUtility.info("The user closes the cookies - that means they exist.");
    }
}
