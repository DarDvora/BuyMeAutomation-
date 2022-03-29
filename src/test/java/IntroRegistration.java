import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class IntroRegistration extends BasePage {
    private WebDriver driver = SingletonWebDriver.getInstance();
    WebDriverWait wait = new WebDriverWait(SingletonWebDriver.getInstance(), Duration.ofSeconds(10));


    public void getRegisterScreen(){
        pressIntroRegistration();
        registrationInsertDetails();
        clickRegister();
    }
    //opening website
    public void entrance (){
        driver.get("https://buyme.co.il/");
        driver.manage().window().maximize();}

    //registrationOrEntrance button
    public void pressIntroRegistration (){
        clickElement(By.className("notSigned"));
        WebElement registerTextLink = getWebElement(By.className("text-link"));
        wait.until(ExpectedConditions.elementToBeClickable(registerTextLink)).click();
    }

    //registration fields
    public void registrationInsertDetails (){
        List <WebElement> inputFields = driver.findElements(By.tagName("input"));
        sendKeysToElementList(0,Constants.NAME,inputFields);
        sendKeysToElementList(1,Constants.EMAIL,inputFields);
        sendKeysToElementList(2,Constants.PASSWORD,inputFields);
        sendKeysToElementList(3,Constants.PASSWORD,inputFields);

        //fields assertion
        String name = getWebElementFromList(inputFields,0).getAttribute("value");
        String email = getWebElementFromList(inputFields,1).getAttribute("value");
        String password = getWebElementFromList(inputFields,2).getAttribute("value");
        String rePassword = getWebElementFromList(inputFields,3).getAttribute("value");
        Assert.assertEquals(name,Constants.NAME);
        Assert.assertEquals(email,Constants.EMAIL);
        Assert.assertEquals(password,Constants.PASSWORD);
        Assert.assertEquals(rePassword,Constants.PASSWORD);

    }

    //registration button
    public void clickRegister (){
        clickElement(By.cssSelector("button[type=submit]"));
    }
}
