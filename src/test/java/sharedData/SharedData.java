package sharedData;

import loggerUtility.LoggerUtility;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

@Getter
public class SharedData {
    protected WebDriver driver;

    @BeforeMethod
    public void prepareEnvironment() {
        boolean ci_cd = Boolean.parseBoolean(System.getProperty("CI_CD"));
        EdgeOptions options = new EdgeOptions();
        if (ci_cd) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-search-engine-choice-screen");
            driver = new EdgeDriver(options);
        } else {
            options.addArguments("--disable-search-engine-choice-screen");
            driver = new EdgeDriver(options);
        }
        driver.get("https://www.salonprovider.ro/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        LoggerUtility.info("The browser has opened successfully!");
    }

//    @AfterMethod
//    public void clearEnvironment(ITestResult result) {
//        if (!result.isSuccess()) {
//            LoggerUtility.info(result.getThrowable().getMessage());
//        }
//        driver.quit();
//        LoggerUtility.info("The browser was closed successfully!");
//    }
}
