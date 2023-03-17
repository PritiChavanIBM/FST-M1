package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebdriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Activity8 extends WebdriverHelper {

    @BeforeMethod
    public void start() {
        System.out.println("Opening browser...");
        openBrowser();
    }

    @Test
    public void verifyIfUserIsLoggedIn(){
        System.out.println("Verify if user is logged in...");
        navigateToUrl("https://alchemy.hguy.co/jobs/wp-admin");

        WebElement username = driver.findElement(By.id("user_login"));
        enterTextIntoWebElement(username,"root");
        WebElement password = driver.findElement(By.id("user_pass"));
        enterTextIntoWebElement(password,"pa$$w0rd");
        WebElement loginButton = driver.findElement(By.id("wp-submit"));
        clickOnWebElement(loginButton);
        WebElement dashboardHeader = driver.findElement(By.xpath("//div[@id='wpbody']//h1"));
        Assert.assertEquals(getTextInWebElement(dashboardHeader),"Dashboard");
        System.out.println("User log in verified successfully...");
    }

    @AfterMethod
    public void cleanup(){
        System.out.println("Closing browser...");
        quitBrowser();
    }
}
