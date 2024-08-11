package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testbase.BaseClass;

public class LoginPage extends BaseClass {
    private final  WebDriver driver;
    By username = By.xpath("//input[@id='username']");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement txtUsername(){
        return driver.findElement(username);



    }

}
