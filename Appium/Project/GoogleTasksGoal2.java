package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GoogleTasksGoal2{
    // Driver Declaration
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }
    // Test method
    @Test
    public void createGoogleTask() throws InterruptedException {
        // Perform the calculation
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/editable_title"))).click();
        driver.switchTo().activeElement();
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Google Keep Title");
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Google Keep description");


        driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();
        //wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/design_bottom_sheet"))).click();

        // Find the result
        List<WebElement> tasks = driver.findElements(AppiumBy.xpath("//android.widget.TextView[contains(@resource-id, 'com.google.android.keep:id/index_note_title')]"));
        List<String> taskNames= new ArrayList<>();
        for(int i=0;i<tasks.size();i++){

            taskNames.add(tasks.get(i).getText());
        }
        System.out.println("tasks : " +taskNames);
        // Assertion
        Assert.assertTrue(taskNames.contains("Google Keep Title"));
    }
}
