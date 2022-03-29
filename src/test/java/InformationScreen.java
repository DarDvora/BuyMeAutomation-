import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class InformationScreen extends BasePage {
    private WebDriver driver;

    public InformationScreen(){this.driver = SingletonWebDriver.getInstance();}
    WebDriverWait wait = new WebDriverWait(SingletonWebDriver.getInstance(), Duration.ofSeconds(10));

    public void senderAndReceiverInformation  () throws InterruptedException {
        sender();
        receiverName();
        event();
        textArea();
        uploadImage();
        continues();
    }

    //my-self and for someone radio button
    public void sender() throws InterruptedException {
        Thread.sleep(5000);
        WebElement forSomeone = getWebElement(By.className("button-forSomeone"));
        wait.until(ExpectedConditions.elementToBeClickable(forSomeone));
        forSomeone.click();
    }
    //receiver name field and assertion
    public void receiverName () throws InterruptedException {
        Thread.sleep(5000);
        sendKeysToElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div[1]/form/div[2]/div[1]/label/input"),Constants.RECEIVERNAME);
        //assertion
        //Assert.assertEquals("//*[@id=\"ember2427\"]",Constants.RECEIVERNAME);
    }
    //blessing type
    public void event (){
        WebElement eventsDropdown = getWebElement(By.className("selected-name"));
        wait.until(ExpectedConditions.elementToBeClickable(eventsDropdown));
        eventsDropdown.click();

        WebElement thanks = getWebElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div[1]/form/div[2]/div[2]/label/div/div[2]/ul/li[4]"));
        wait.until(ExpectedConditions.elementToBeClickable(thanks));
        thanks.click();

    }
    //blessing text
    public void textArea(){
        WebElement clearText = driver.findElement(By.tagName("textarea"));
        clearText.clear();
        sendKeysToElement(By.tagName("textarea"),"thank you");
    }
    //upload image
    public void uploadImage() throws InterruptedException {
        WebElement upload = driver.findElement(By.id("ember2447"));
        Thread.sleep(5000);
        upload.sendKeys("C:\\Users\\Dvora.W10N-LNX-DVORAD\\Desktop\\IMG_0031.JPG");
        Thread.sleep(30000);
    }

    public void continues (){
        clickElement(By.cssSelector("button[type=submit]"));
    }
}
