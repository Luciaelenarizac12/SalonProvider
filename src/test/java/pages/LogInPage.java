package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import helpers.CommonNeeds;
import loggerUtility.LoggerUtility;
import objectData.LogInPageObject;
import objectData.ValidareProfil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LogInPage extends BasePage {

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form[@id='form_login']//input[@name='email']")
    private WebElement emailElement;

    @FindBy(xpath = "//form[@id='form_login']//input[@name='parola']")
    private WebElement passwordElement;

    @FindBy(xpath = "//button[normalize-space()='Logheaza-te']")
    private WebElement logInElement;

    @FindBy(xpath = "//a[@href='javascript:void(0)' and @class='click_to_open_user']")
    private WebElement checkingTheProfile;

    @FindBy(xpath = "(//a[normalize-space()='Lucia Rizac'])[1]")
    private WebElement corectUserElement;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameElementValidate;

    @FindBy(xpath = "//input[@id='second']")
    private WebElement lastNameElementValidate;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailElementValidate;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneElementValidate;

    public void enterCredentials(LogInPageObject testData) {
        commonNeeds.fillElement(emailElement, testData.getEmailValue());
        LoggerUtility.info("The user has entered their email address.");
        commonNeeds.fillElement(passwordElement, testData.getPasswordValue());
        LoggerUtility.info("The user has entered their password.");
        commonNeeds.clickJSElement(logInElement);
        LoggerUtility.info("The user clicked on the login button.-->The user successfully logged into the Salon Provider platform.");

    }

    public void accessTheUsersProfile(LogInPageObject testData) {
        commonNeeds.clickJSElement(checkingTheProfile);
        LoggerUtility.info("The user clicked on the profile button.");
        commonNeeds.waitForElementVisibile(corectUserElement);
        commonNeeds.clickJSElement(corectUserElement);
        LoggerUtility.info("The user clicked on their personal profile: 'Lucia Rizac'.");

    }

    public void validateUserProfile(ValidareProfil testDataProfile) {
        commonNeeds.waitForElementVisibile(nameElementValidate);
        commonNeeds.waitForElementVisibile(lastNameElementValidate);
        commonNeeds.waitForElementVisibile(emailElementValidate);
        commonNeeds.waitForElementVisibile(phoneElementValidate);

        // validam valorile de pe pagina de profil
        String expectedName = testDataProfile.getNameElementValidate();
        String expectedLastName = testDataProfile.getLastNameElementValidate();
        String expectedEmail = testDataProfile.getEmailElementValidate();
        String expectedPhone = testDataProfile.getPhoneElementValidate();

        //validam acum fiecare element - stanga <-> dreapta
        String actualName = nameElementValidate.getAttribute("value");
        Assert.assertEquals(actualName, expectedName, "Numele nu este corect!");

        String actualLastName = lastNameElementValidate.getAttribute("value");
        Assert.assertEquals(actualLastName, expectedLastName, "Prenumele nu este corect!");

        String actualEmail = emailElementValidate.getAttribute("value");
        Assert.assertEquals(actualEmail, expectedEmail, "Email-ul nu este corect!");

        String actualPhone = phoneElementValidate.getAttribute("value");
        Assert.assertEquals(actualPhone, expectedPhone, "Numărul de telefon nu este corect!");

        LoggerUtility.info("Profilul utilizatorului a fost validat cu succes: " +
                expectedName + " " + expectedLastName + ", Email: " + expectedEmail + ", Telefon: " + expectedPhone);
    }

}



