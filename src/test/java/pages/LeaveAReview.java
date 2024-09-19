package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeaveAReview extends BasePage{
    public LeaveAReview(WebDriver driver) {
        super(driver);
    }

    // cod ul produsului: MA19001

    @FindBy(xpath = "//a[contains(@class, 'click_to_open_search')]")
    private WebElement searchElement;

    @FindBy(xpath = "//input[@id='keyword']")
    private WebElement extendedSearchElement;

    @FindBy(xpath = "//a[normalize-space()='Mascara TRIPLE THREAT']")
    private WebElement rimmelElement;

    @FindBy(xpath = "//button[@aria-label='Close dialog'][1]")
    private WebElement svgElement;

    @FindBy(xpath = "//span[@id='header-tab-recenzii']")
    private WebElement reviewElement;

    @FindBy(xpath = "//a[normalize-space()='Adauga o recenzie']")
    private WebElement addAPersonalReview;

    @FindBy(xpath = "//input[@id='nume']")
    private WebElement reviewerFirstName;

    @FindBy(xpath = "//input[@id='prenume']")
    private WebElement reviewerLastName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailReviewer;

    @FindBy(xpath = "//input[@value='4']")
    private WebElement starSelect;

    @FindBy(xpath = "//textarea[@name='review']")
    private WebElement textReview;

    @FindBy(xpath = "//button[@id='send_review']")
    private WebElement submitReview;



    public void searchForARimmel(RemoveSVGElements removeSVGElements){
        commonNeeds.clickJSElement(searchElement);
        LoggerUtility.info("The user accesses the search Button.");
        commonNeeds.waitForElementVisibile(extendedSearchElement);
        LoggerUtility.info("The user is waiting for the element to become visible.");
        commonNeeds.fillElement(extendedSearchElement, "MA19001");
        LoggerUtility.info("The user accesses the search bar, enters the search term 'MA19001,' and presses Enter.");
        extendedSearchElement.submit();
        LoggerUtility.info("The user has been redirected to the searched product");
        commonNeeds.waitForElementVisibile(rimmelElement);
        LoggerUtility.info("The user is waiting for the element to become visible.");
        commonNeeds.clickJSElement(rimmelElement);
        LoggerUtility.info("The user then clicked on the product.");
        removeSVGElements.removeAllSVGAds();
        commonNeeds.waitForElementVisibile(svgElement);
        commonNeeds.clickJSElement(svgElement);
    }

    public void accessReview(){
        commonNeeds.scrollPage(0,50);
        commonNeeds.clickJSElement(reviewElement);
        LoggerUtility.info("The user clicked on the review button.");
        commonNeeds.clickJSElement(addAPersonalReview);
        LoggerUtility.info("The user accesses the review section.");
        commonNeeds.scrollPage(0,50);
    }
    public void submitReviewForm(String firstName, String lastName, String email, String reviewText) {

        commonNeeds.scrollPage(0,50);
        commonNeeds.fillElement(reviewerFirstName, firstName);
        LoggerUtility.info("Entered reviewer first name: " + firstName);

        commonNeeds.fillElement(reviewerLastName, lastName);
        LoggerUtility.info("Entered reviewer last name: " + lastName);

        commonNeeds.fillElement(emailReviewer, email);
        LoggerUtility.info("Entered reviewer email: " + email);

        commonNeeds.clickJSElement(starSelect);
        LoggerUtility.info("Selected the star rating.");

        commonNeeds.fillElement(textReview, reviewText);
        LoggerUtility.info("Entered review text: " + reviewText);

    }

}
