package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.SignUpPage;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected SignUpPage signUpPage;


    @BeforeClass
    public void setUpSystem()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        signUpPage =new SignUpPage(driver);
    }
    @BeforeMethod
    public void openWebsite()
    {
        driver.navigate().to("https://phptravels.net/signup");

    }
    @AfterMethod
    public void takeScreenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenShot = camera.getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot Taken: " + screenShot.getAbsolutePath());
            try {
                Files.move(screenShot, new File("resources/screenshots" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @AfterClass
    public void TearDown()
    {
        driver.quit();
    }
}





