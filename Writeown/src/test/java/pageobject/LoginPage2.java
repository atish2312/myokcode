package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginPage2 {
    private final  WebDriver driver;
    By password = By.xpath("//input[@id='password']");

    public LoginPage2(WebDriver driver){
        this.driver = driver;
    }
    public WebElement txtPassword(){
        return driver.findElement(password);

    }
}
