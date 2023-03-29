package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebdriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Activity5 extends WebdriverHelper {

    @BeforeMethod
    public void start() {
        System.out.println("Opening browser...");
        openBrowser();
    }

    @Test
    public void navigateToJobsPage(){
        System.out.println("Navigate To Jobs Page...");
        navigateToUrl("https://alchemy.hguy.co/jobs/");

        WebElement locator = driver.findElement(By.linkText("Jobs"));
        clickOnWebElement(locator);
        String text= getWebsiteTitle();
        Assert.assertEquals(text,"Jobs – Alchemy Jobs");

    }

    @AfterMethod
    public void cleanup(){
        System.out.println("Closing browser...");
        quitBrowser();
    }
}
