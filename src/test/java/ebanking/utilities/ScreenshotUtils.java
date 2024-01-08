package ebanking.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    // Method to capture screenshot
    public static void captureScreenshot(WebDriver driver, ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                // Capture the screenshot
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);

                // Get the timestamp to create a unique filename
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

                // Specify the existing directory where screenshots will be saved
                String screenshotDir = "C:\\Users\\LEGION\\eclipse-workspace\\ebankingV1\\screenshots\\";

                // Create the directory if it doesn't exist
                Path directoryPath = Paths.get(screenshotDir);
                if (Files.notExists(directoryPath)) {
                    Files.createDirectories(directoryPath);
                }

                // Specify the filename
                String screenshotName = result.getName() + "_" + timestamp + ".png";

                // Specify the complete path to save the screenshot
                String screenshotPath = screenshotDir + screenshotName;

                // Copy the screenshot to the specified path
                Files.copy(source.toPath(), Paths.get(screenshotPath));

                System.out.println("Screenshot captured: " + screenshotPath);
            } catch (IOException e) {
                System.out.println("Exception while taking screenshot: " + e.getMessage());
            }
        }
    }
}
