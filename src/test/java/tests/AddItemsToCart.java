package tests;

import org.testng.annotations.Test;
import pages.AddItemsfromMakeupSection;
//import pages.CookiesHomePage;
import pages.CookiesPage;
import pages.RemoveSVGElements;
import sharedData.SharedData;

public class AddItemsToCart extends SharedData {

    @Test
    public void testMethod(){

        CookiesPage cookiesPage = new CookiesPage(getDriver());
        cookiesPage.closeCookies();

        RemoveSVGElements removeSVGElements = new RemoveSVGElements(getDriver());
        removeSVGElements.removeAllSVGAds();

        AddItemsfromMakeupSection addItemsfromMakeupSection=new AddItemsfromMakeupSection(driver);
        addItemsfromMakeupSection.searchMyProduct(removeSVGElements);
        addItemsfromMakeupSection.addProduct();
        addItemsfromMakeupSection.validateExistanceOfProductIntheCart();

    }
}
