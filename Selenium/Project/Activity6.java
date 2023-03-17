package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebdriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Activity6 extends WebdriverHelper {

    @BeforeMethod
    public void start() {
        System.out.println("Opening browser...");
        openBrowser();
    }

    @Test
    public void applyForAJob() throws InterruptedException {
        System.out.println("Navigate To Jobs Page...");
        navigateToUrl("https://alchemy.hguy.co/jobs/");

        WebElement jobLink = driver.findElement(By.linkText("Jobs"));
        clickOnWebElement(jobLink);
        System.out.println("Apply for a Job ...");
        WebElement keywordTextbox= driver.findElement(By.id("search_keywords"));
        keywordTextbox.sendKeys("java");

        WebElement searchJobsButton = driver.findElement(By.xpath("//input[@value='Search Jobs']"));
        clickOnWebElement(searchJobsButton);

        Thread.sleep(5000);
        List<WebElement> jobList = driver.findElements(By.xpath("//li[@style='visibility: visible;']//a"));
        clickOnWebElement(jobList.get(0));

        WebElement applyForJobsButton = driver.findElement(By.xpath("//input[@value='Apply for job']"));
        clickOnWebElement(applyForJobsButton);

        Thread.sleep(5000);
        WebElement emailAddressOfRecruiter = driver.findElement(By.xpath("//a[@class='job_application_email']"));
        String emailAddress=getTextInWebElement(emailAddressOfRecruiter);

        System.out.println("email address of recruiter is : "+emailAddress);

        System.out.println("Applied for the job successfully!!!!!!!!!");


    }

    @AfterMethod
    public void cleanup(){
        System.out.println("Closing browser...");
        quitBrowser();
    }
}
