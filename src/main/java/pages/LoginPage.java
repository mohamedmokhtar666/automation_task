package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
private WebDriver driver;
private By emailField=By.xpath("//input[@placeholder='Email']");
private By passwordField=By.xpath("//input[@placeholder='Password']");
private By loginButton=By.xpath("//button[@type='submit']//*[text()='Login']");


    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public HomePage setLogin(String email,String password)
    {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
