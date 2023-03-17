package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebdriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Activity4 extends WebdriverHelper {

    @BeforeMethod
    public void start() {
        System.out.println("Opening browser...");
        openBrowser();
    }

    @Test
    public void verifySecondHeading(){
        System.out.println("Verify Second Heading...");
        navigateToUrl("https://alchemy.hguy.co/jobs/");

        WebElement locator = driver.findElement(By.xpath("//h2"));
        String text = getTextInWebElement(locator);
        Assert.assertEquals(text,"Quia quis non");

    }

    @AfterMethod
    public void cleanup(){
        System.out.println("Closing browser...");
        quitBrowser();
    }
}
