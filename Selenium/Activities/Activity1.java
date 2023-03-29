package activities;

import org.testng.Assert;
import utils.WebdriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Activity1 extends WebdriverHelper {

    @BeforeMethod
    public void start() {
        System.out.println("Opening browser...");
        openBrowser();
    }

    @Test
    public void verifyWebsiteTitle() {
        System.out.println("Verify Website Title...");
        navigateToUrl("https://alchemy.hguy.co/jobs/");
        String title =getWebsiteTitle();
        Assert.assertEquals(title,"Alchemy Jobs – Job Board Application");

    }

    @AfterMethod
    public void cleanup(){
        System.out.println("Closing browser...");
        quitBrowser();
    }
}
