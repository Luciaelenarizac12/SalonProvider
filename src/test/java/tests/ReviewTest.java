package tests;

import org.testng.annotations.Test;
//import pages.CookiesHomePage;
import pages.CookiesPage;
import pages.LeaveAReview;
import pages.RemoveSVGElements;
import sharedData.SharedData;

public class ReviewTest extends SharedData {

    @Test
    public void testMethod(){

        CookiesPage cookiesPage = new CookiesPage(getDriver());
        cookiesPage.closeCookies();

        RemoveSVGElements removeSVGElements = new RemoveSVGElements(getDriver());
        removeSVGElements.removeAllSVGAds();

        LeaveAReview leaveAReview= new LeaveAReview(getDriver());
        leaveAReview.searchForARimmel(removeSVGElements);
        leaveAReview.accessReview();
        leaveAReview.submitReviewForm("Anita", "Popescu", "deDragulElemplului@yahoo.com", "Great product!");

    }

}
