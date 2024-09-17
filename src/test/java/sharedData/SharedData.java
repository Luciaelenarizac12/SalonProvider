package sharedData;

import loggerUtility.LoggerUtility;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Getter
public class SharedData {
    protected WebDriver driver;

    @BeforeMethod
    public void prepareTheEnvirenment() {
        driver = new EdgeDriver();
        driver.get("https://www.salonprovider.ro/");
        driver.manage().window().maximize();
        LoggerUtility.info("The browser is opened successfully.");
    }

//    @AfterMethod
//    public void clearEnvironment(ITestResult result) {
//        if (!result.isSuccess()) {
//            LoggerUtility.error(result.getThrowable().getMessage());
//        }
//        driver.quit();
//        LoggerUtility.info("The browser is closed with success");
//    }
}
