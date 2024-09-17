package tests;

import helpers.CommonNeeds;
import loggerUtility.LoggerUtility;
import lombok.extern.slf4j.Slf4j;
import objectData.LogInPageObject;
import objectData.ValidareProfil;
import org.testng.annotations.Test;
import pages.CookiesHomePage;
import pages.LogInPage;
import pages.NavigateTO;
import pages.RemoveSVGElements;
import sharedData.SharedData;

@Slf4j
public class LoginTest extends SharedData {

    @Test

    public void testMethod() {
        LogInPageObject testData = new LogInPageObject("src/test/resources/testData/LogInPageData.json");

        CookiesHomePage cookiesHomePage = CookiesHomePage.getInstance(driver);
        cookiesHomePage.cookieForHomePage();

        RemoveSVGElements removeSVGElements = new RemoveSVGElements(getDriver());
        removeSVGElements.removeAllSVGAds();

        NavigateTO navigateTO = new NavigateTO(getDriver());
        navigateTO.navigateToLoginPage();

        ValidareProfil testDataProfile=new ValidareProfil("src/test/resources/testData/ValidareProfilData.json");

        LogInPage logInPage =new LogInPage(getDriver());
        logInPage.enterCredentials(testData);
        logInPage.accessTheUsersProfile(testData);
        logInPage.validateUserProfile(testDataProfile);

    }




}
