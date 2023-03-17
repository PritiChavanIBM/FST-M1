package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebdriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

public class Activity7 extends WebdriverHelper {
    Date timestamp=new Date();
    @BeforeMethod
    public void start() {
        System.out.println("Opening browser...");
        openBrowser();
    }

    @Test
    public void createAJob() throws InterruptedException {
        System.out.println("Navigate To create a Jobs Page...");
        navigateToUrl("https://alchemy.hguy.co/jobs/");

        WebElement postJobLink = driver.findElement(By.linkText("Post a Job"));
        clickOnWebElement(postJobLink);
        System.out.println("Post a Job ...");
        WebElement companyName= driver.findElement(By.id("company_name"));
        enterTextIntoWebElement(companyName,"SAP company"+timestamp.toLocaleString());

        WebElement companyWebsite = driver.findElement(By.id("company_website"));
        enterTextIntoWebElement(companyWebsite,"sapcompany.com");
        WebElement previewButton = driver.findElement(By.xpath("//input[@value='Preview']"));
        clickOnWebElement(previewButton);

        WebElement createAccountEmail= driver.findElement(By.id("create_account_email"));
        enterTextIntoWebElement(createAccountEmail,"pritiTest"+timestamp.getSeconds()+"@xyz.com");
        WebElement jobTitle= driver.findElement(By.id("job_title"));
        enterTextIntoWebElement(jobTitle,"Test Automation engineer");

        switchToIFrame("job_description_ifr");
        WebElement jobDescription= driver.findElement(By.id("tinymce"));
        enterTextIntoWebElement(jobDescription,"Test Automation engineer should have good automation knowledge");

        switchBackToMainWindow();
        WebElement applicationURL= driver.findElement(By.id("application"));
        enterTextIntoWebElement(applicationURL,"http://mytestwebsite.com");


        clickOnWebElement(previewButton);
        WebElement submitListingButton = driver.findElement(By.xpath("//input[@value='Submit Listing']"));
        clickOnWebElement(submitListingButton);

        WebElement jobLink = driver.findElement(By.linkText("Jobs"));
        clickOnWebElement(jobLink);

        WebElement keywordTextbox= driver.findElement(By.id("search_keywords"));
        keywordTextbox.sendKeys("Test Automation engineer");

        WebElement searchJobsButton = driver.findElement(By.xpath("//input[@value='Search Jobs']"));
        clickOnWebElement(searchJobsButton);

        List<WebElement> jobList = driver.findElements(By.xpath("//li[@style='visibility: visible;']//a"));

        Assert.assertNotNull(jobList);
        System.out.println("Job posted successfully!!!!!!!!!");


    }

    @AfterMethod
    public void cleanup(){
        System.out.println("Closing browser...");
        quitBrowser();
    }
}
