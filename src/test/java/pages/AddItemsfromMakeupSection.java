package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddItemsfromMakeupSection extends BasePage {

    public AddItemsfromMakeupSection(WebDriver driver) {
        super(driver);
    }

    //vom cauta un fond de ten si vom pune niste filtre, ulterior il vom adauga in cos

    @FindBy(xpath = "//a[contains(@class, 'click_to_open_search') and img[contains(@src, 'search-png.png')]]")
    private WebElement searchElement;


    @FindBy(xpath = "//input[@id='keyword']")
    private WebElement extendedSearchElement;

    @FindBy(xpath = "//input[@type='checkbox' and @value='make-up-for-ever--8']")
    private WebElement checkMakeUpForeverBrandElement;

    // facem click pe "acoperire" si selectam "Mediu"

    @FindBy(xpath = "//span[normalize-space()='Acoperire']")
    private WebElement coverageFilterElement;


    @FindBy(xpath = "//input[@type='checkbox' and @class='checkbox_filtrare' and @name='acoperire' and @value='mediu--5' and @data-name='Mediu']")
    private WebElement selectCoverageTypeElement;

    //facem filtrare si pe formula://span[normalize-space()='Formula']

    @FindBy(xpath = "//span[normalize-space()='Formula']")
    private WebElement formulaFilterElement;

    //selectam stick : //input[@type='checkbox' and @class='checkbox_filtrare' and @name='formula' and @value='stick--15' and @data-name='Stick']

    @FindBy(xpath = "//input[@value='stick--15']")
    private WebElement stickElement;

    //am selectat produsul si am dat click pe el: //a[normalize-space()='STICK FOND DE TEN ULTRA HD']

    @FindBy(xpath = "//a[normalize-space()='STICK FOND DE TEN ULTRA HD']")
    private WebElement stickFondDeTenElement;

    //am adaugat produsul in cos : //button[@id='adauga_in_cos_button']

    @FindBy(xpath = "//button[@id='adauga_in_cos_button']")
    private WebElement addProductToCart;

    //verificam cosul daca intr-adevar produsul a fost adaugat, deci dam click pe cos:

    @FindBy(xpath = "//a[@href='javascript:void(0)' and @class='click_to_open_shop' and .//span[@id='numar_cantitate_heder' and text()='1'] and .//img[@src='/assets/images/newicons/cos-png.png' and @alt='cart']]")
    private WebElement cartElement;

    //dam click pe "1 produs" ca sa ne redirectioneze catre cos

    @FindBy(xpath = "//p//a[@href='/cart' and .//span[@id='header_qty' and text()='1'] and .//span[@id='text_context_produse' and .//span[@id='text_context_produse_sg' and text()='produs']]]")
    private WebElement checkProductElement;

    //facem o validare ca exista pagina de cos, setul de cuvinte "COSUL MEU" si "STICK FOND DE TEN ULTRA HD"

    @FindBy(xpath = "//h2[normalize-space()='Cosul meu']")
    private WebElement myCartElement;

    @FindBy(xpath = "//p[normalize-space()='STICK FOND DE TEN ULTRA HD']")
    private WebElement nameOfTheProduct;


    public void searchMyProduct() {
        commonNeeds.clickElement(searchElement);
        LoggerUtility.info("The user accesses the search Button.");
        commonNeeds.waitForElementVisibile(extendedSearchElement);
        LoggerUtility.info("The user is waiting for the element to become visible.");
        commonNeeds.fillElement(extendedSearchElement, "fond de ten");
        LoggerUtility.info("The user accesses the search bar, enters the search term 'fond de ten,' and presses Enter.");
        extendedSearchElement.submit();
        LoggerUtility.info("The user has been redirected to the searched product");
        commonNeeds.scrollPage(0,150);
        commonNeeds.clickJSElement(checkMakeUpForeverBrandElement);
        LoggerUtility.info("The user has selected the product brand.");
        commonNeeds.scrollPage(0,100);
        commonNeeds.clickJSElement(coverageFilterElement);
        LoggerUtility.info("The user clicked on the coverage filter");
        commonNeeds.clickJSElement(selectCoverageTypeElement);
        LoggerUtility.info("The user chose 'medium' coverage.");
        commonNeeds.scrollPage(0,100);
        commonNeeds.clickJSElement(formulaFilterElement);
        LoggerUtility.info("The user then clicked on the 'Formula' filter category.");
        commonNeeds.clickJSElement(stickElement);
        LoggerUtility.info("The user selected the 'stick' variant.");

    }

    public void addProduct() {
        commonNeeds.scrollPage(0,200);
        commonNeeds.waitForElementVisibile(stickFondDeTenElement);
        LoggerUtility.info("The user is waiting for the element to become visible.");
        commonNeeds.clickElement(stickFondDeTenElement);
        LoggerUtility.info("The user selects the product 'STICK FOND DE TEN ULTRA HD'.");
        commonNeeds.waitForElementVisibile(addProductToCart);
        LoggerUtility.info("The user is waiting for the element to become visible.");
        commonNeeds.clickElement(addProductToCart);
        LoggerUtility.info("The user adds the product to the cart.");

    }

    public void validateExistanceOfProductIntheCart() {
        // Așteaptam și verificam daca elementul cartElement este vizibil
        commonNeeds.waitForElementVisibile(cartElement);
        LoggerUtility.info("The user is waiting for the element to become visible.");
        commonNeeds.clickJSElement(cartElement);
        LoggerUtility.info("The user clicks on the cart to see if there is any product.");

        // verificam daca elementul checkProductElement este vizibil
        commonNeeds.waitForElementVisibile(checkProductElement);
        LoggerUtility.info("The user is waiting for the element to become visible.");
        checkProductElement.click();
        LoggerUtility.info("The user can see that there is 1 product and clicks on it.");

        // ne asiguram ca elementul STICK FOND DE TEN ULTRA HD este adaugat in cos, validam dupa prezenta numelui
        String expectedProductText = "STICK FOND DE TEN ULTRA HD";
        String cartName= "COSUL MEU";
        String actualProductText = nameOfTheProduct.getText();
        Assert.assertEquals(actualProductText, expectedProductText, "The product in the cart does not match the expected NAME.");
        String actualCartName = myCartElement.getText();
        Assert.assertEquals(cartName, actualCartName, "We are not in the cart section, check again!");

    }
}





