package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebdriverHelper {
    public WebDriver driver;
    public void openBrowser(){
        driver = new FirefoxDriver();
    }

    public void navigateToUrl(String url){
        driver.get(url);
    }

    public void quitBrowser(){
        driver.quit();
    }
    public String getWebsiteTitle(){
       String title= driver.getTitle();
        return title;
    }
    public String getTextInWebElement(WebElement element){
        String text= element.getText();
        return text;
    }

    public String getAttributeValueOfWebElement(WebElement element, String attribute){
        String value= element.getAttribute(attribute);
        return value;
    }
    public void clickOnWebElement(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }
    public List<String> getListOfValues(List<WebElement> listLocator){
        List<String> list = null;
        for (int i=0;i<listLocator.size();i++){
            String value= listLocator.get(i).getText();
            list.add(value);
        }
        return list;
    }
    public void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void enterTextIntoWebElement(WebElement element,String inputValue){
        element.clear();
        element.sendKeys(inputValue);
    }
    public void switchToIFrame(String frameId){
        driver.switchTo().frame(frameId);
    }

    public void switchBackToMainWindow(){
        driver.switchTo().parentFrame();
    }

    public void switchToFocusedWindow(){
        driver.switchTo().activeElement();
    }
}
