package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebdriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class Activity9 extends WebdriverHelper {

    Date timestamp=new Date();
    @BeforeMethod
    public void start() {
        System.out.println("Opening browser...");
        openBrowser();
    }

    @Test
    public void createJobListing() throws InterruptedException {
        System.out.println("creating Job Listing...");
        navigateToUrl("https://alchemy.hguy.co/jobs/wp-admin");

        WebElement username = driver.findElement(By.id("user_login"));
        enterTextIntoWebElement(username,"root");
        WebElement password = driver.findElement(By.id("user_pass"));
        enterTextIntoWebElement(password,"pa$$w0rd");
        WebElement loginButton = driver.findElement(By.id("wp-submit"));
        clickOnWebElement(loginButton);
        Thread.sleep(5000);
        WebElement jobPostingIcon = driver.findElement(By.cssSelector(".menu-icon-job_listing"));
        clickOnWebElement(jobPostingIcon);
        WebElement addNewButton = driver.findElement(By.linkText("Add New"));
        clickOnWebElement(addNewButton);
        WebElement closeDialog = driver.findElement(By.xpath("//button[@aria-label='Close dialog']"));
        clickOnWebElement(closeDialog);
        WebElement postTitle = driver.findElement(By.id("post-title-0"));
        String titleEntered="Priti Test"+timestamp.toLocaleString();
        enterTextIntoWebElement(postTitle,titleEntered);
        WebElement publishButton1 = driver.findElement(By.xpath("//a[@class='components-button editor-post-preview is-secondary']//following-sibling::button[contains(@class,'editor-post-publish-button__button')]"));
        clickOnWebElement(publishButton1);
        WebElement publishButton2 = driver.findElement(By.xpath("//button[text()='Publish']"));
        clickOnWebElement(publishButton2);
        Thread.sleep(5000);

        WebElement isJobCreated = driver.findElement(By.xpath("//div[@class='editor-post-publish-panel']//div[@class='components-panel__body post-publish-panel__postpublish-header is-opened']"));
        String validateCreatedJob = getTextInWebElement(isJobCreated);

        Assert.assertEquals(validateCreatedJob,titleEntered+" is now live.");
        System.out.println("Job created successfully");
    }

    @AfterMethod
    public void cleanup(){
        System.out.println("Closing browser...");
        quitBrowser();
    }
}
