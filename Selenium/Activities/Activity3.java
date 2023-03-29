package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebdriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Activity3 extends WebdriverHelper {

    @BeforeMethod
    public void start() {
        System.out.println("Opening browser...");
        openBrowser();
    }

    @Test
    public void getHeaderImageUrl(){
        System.out.println("Get header image URL...");
        navigateToUrl("https://alchemy.hguy.co/jobs/");

        WebElement locator = driver.findElement(By.xpath("//div[@class='post-thumb-img-content post-thumb']//img"));
        String headerImageUrl = getAttributeValueOfWebElement(locator,"src");
        System.out.println("Header Image URL is : "+ headerImageUrl);

    }

    @AfterMethod
    public void cleanup(){
        System.out.println("Closing browser...");
        quitBrowser();
    }
}
