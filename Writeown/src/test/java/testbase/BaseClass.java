package testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;
import utilities.CustomWaits;
import utilities.TakeScreenshots;

public class BaseClass {
    public ConfigReader configReader;
    public CustomWaits waits;
    public TakeScreenshots takeScreenshots;
    public WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-origin");
        options.addArguments("-start-maximized");
        driver = new ChromeDriver(options);
        initializedUtilities();
    }
    public void initializedUtilities(){
        configReader = new ConfigReader();
        waits = new CustomWaits(driver,configReader);
        takeScreenshots = new TakeScreenshots(driver,configReader.getScreenShotPathProperty("Screenshots"));
    }
    @BeforeMethod
    public void commonUrl(){
        System.out.println("BeforeMethod");
        driver.get(configReader.getBaseUrl("baseUrl"));


    }
}
