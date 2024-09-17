package tests;

import loggerUtility.LoggerUtility;
import org.testng.annotations.Test;
import pages.AddItemsfromMakeupSection;
import pages.CookiesHomePage;
import pages.RemoveSVGElements;
import sharedData.SharedData;

public class AddItemsToCart extends SharedData {

    @Test
    public void testMethod(){

        CookiesHomePage cookiesHomePage = CookiesHomePage.getInstance(driver);
        cookiesHomePage.cookieForHomePage();

        RemoveSVGElements removeSVGElements = new RemoveSVGElements(getDriver());
        removeSVGElements.removeAllSVGAds();

        AddItemsfromMakeupSection addItemsfromMakeupSection=new AddItemsfromMakeupSection(driver);
        addItemsfromMakeupSection.searchMyProduct();
        addItemsfromMakeupSection.addProduct();
        addItemsfromMakeupSection.validateExistanceOfProductIntheCart();

    }
}
