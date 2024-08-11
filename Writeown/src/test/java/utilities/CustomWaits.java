package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomWaits {
    public  WebDriverWait wait;

    public CustomWaits(WebDriver driver,ConfigReader configReader){
        int timeout = configReader.getWaitTime("Explicit");
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }
    public WebElement waitForElementClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public WebElement waitForElementVisible(WebElement element){
        return  wait.until(ExpectedConditions.visibilityOf(element));
    }

}
