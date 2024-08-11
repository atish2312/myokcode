package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TakeScreenshots {
    private final WebDriver driver;
    private final String Screenshots;

    public TakeScreenshots(WebDriver driver, String Screenshots) {
        this.driver = driver;
        this.Screenshots = Screenshots;
    }

    public String captureScreenshot(String filename) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.createDirectories(Paths.get(Screenshots).getParent());
            FileUtils.copyFile(file, new File(Screenshots + File.separator + filename));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("take Screenshot class not load");
        }
        return filename;
    }
}









