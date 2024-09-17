package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class RemoveSVGElements extends BasePage {


    public RemoveSVGElements(WebDriver driver) {
        super(driver);
    }

    public void removeAllSVGAds() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "var svgs = document.getElementsByTagName('svg');" +
                        "for(var i=0; i<svgs.length; i++) {" +
                        "  svgs[i].parentNode.removeChild(svgs[i]);" +
                        "}"
        );
        LoggerUtility.info("SVG elements have been removed after the redirection.");
    }
}
