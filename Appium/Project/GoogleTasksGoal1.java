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

public class GoogleTasksGoal1 {
    // Driver Declaration
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
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
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/design_bottom_sheet"))).click();
        driver.switchTo().activeElement();
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();


        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/design_bottom_sheet"))).click();
        //Thread.sleep(5000);
        driver.switchTo().activeElement();
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/design_bottom_sheet"))).click();
        driver.switchTo().activeElement();
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        // Find the result
        List<WebElement> tasks = driver.findElements(AppiumBy.xpath("//android.widget.TextView[contains(@resource-id, 'com.google.android.apps.tasks:id/task_name')]"));
        List<String> taskNames= new ArrayList<>();
        for(int i=0;i<tasks.size();i++){

            taskNames.add(tasks.get(i).getText());
        }
        System.out.println("tasks : " +taskNames);
        // Assertion
        Assert.assertTrue(taskNames.contains("Complete Activity with Google Tasks"));
        Assert.assertTrue(taskNames.contains("Complete Activity with Google Keep"));
        Assert.assertTrue(taskNames.contains("Complete the second Activity Google Keep"));
    }
}
