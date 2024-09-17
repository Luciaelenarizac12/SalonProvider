package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonNeeds {
    public WebDriver driver;

    // Constructor

    public CommonNeeds(WebDriver driver) {
        this.driver = driver;
    }


    public void clickJSElement(WebElement element) {
        waitForElementToBeClickable(element);
        JavascriptExecutor jsclick = (JavascriptExecutor) driver;
        jsclick.executeScript("arguments[0].scrollIntoView(true);", element);
        jsclick.executeScript("arguments[0].click();", element);
    }

    public void waitForElementVisibile(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void clickJSElementToBeClickable(WebElement element) {
        waitForElementVisibile(element);
        JavascriptExecutor jsclick = (JavascriptExecutor) driver;
        jsclick.executeScript("arguments[0].click();", element);
    }

    public void clickElement(WebElement element) {
        waitForElementVisibile(element);
        element.click();
    }

    public void fillElement(WebElement element, String text) {
        waitForElementVisibile(element);
        element.sendKeys(text);

    }

    public void scrollPage(Integer x, Integer y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + ", " + y + ")", "");
    }
    public void waitForSVGElements() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("svg")));
    }


}
