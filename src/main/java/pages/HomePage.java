package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By resultText=By.xpath(" //h2[@class='sec__title font-size-30 text-white']//span[@style='text-transform:capitalize']");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public String getText()
    {
       return driver.findElement(resultText).getText();
    }

}
