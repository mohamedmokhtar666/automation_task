package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SignUpPage {
private WebDriver driver;
private By firstNameField=By.name("first_name");
private By lastNameField=By.name("last_name");
private By phoneField=By.xpath("//input[@name='phone']");
private By emailField=By.xpath("//input[@name='email']");
private By passwordField=By.xpath("//input[@name='password']");
private By robotBox=By.xpath("");
private By signUpButton=By.xpath("//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']");


public SignUpPage(WebDriver driver)
{
    this.driver=driver;
}
public LoginPage signUpProcess_PartiallyAutomated(String firstName, String lastName, String phone, String email, String password)
{

    driver.findElement(firstNameField).sendKeys(firstName);
    driver.findElement(lastNameField).sendKeys(lastName);
    driver.findElement(phoneField).sendKeys(phone);
    driver.findElement(emailField).sendKeys(email);
    driver.findElement(passwordField).sendKeys(password);
    FluentWait wait=new FluentWait(driver).withTimeout(Duration.ofSeconds(20)).
            pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(signUpButton)));
    driver.findElement(signUpButton).click();

    return new LoginPage(driver);
}
    public LoginPage signUpProcess_FullyAutomated(String firstName, String lastName, String phone, String email, String password)
    {

        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        switchToFrame();
        FluentWait wait=new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(signUpButton)));
        driver.findElement(signUpButton).click();

        return new LoginPage(driver);
    }
private void switchToFrame()
{
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='reCAPTCHA']")));
    WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='recaptcha-checkbox-border']")));
    element.click();
    driver.switchTo().parentFrame();

}




}
