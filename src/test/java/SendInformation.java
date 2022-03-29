import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SendInformation extends BasePage {
        private WebDriver driver;

        public SendInformation() {this.driver = SingletonWebDriver.getInstance();}

        WebDriverWait wait = new WebDriverWait(SingletonWebDriver.getInstance(), Duration.ofSeconds(10));

        public void informationToPayment () throws InterruptedException {
            now();
            email();
            sendEmail();
            payment();
        }
        //later or now radio button
        public void now (){
            clickElement(By.className("button-now"));
        }
        //email button
        public void email(){
            WebElement email = getWebElement(By.cssSelector("svg[gtm=method-email]"));
            wait.until(ExpectedConditions.elementToBeClickable(email));
            email.click();
        }
        //insert email address
        public void sendEmail() throws InterruptedException {
            Thread.sleep(3000);
            sendKeysToElement(By.id("email"),"ddd@d.com");
        }
        //payment button
        public void payment(){
            WebElement payment = getWebElement(By.cssSelector("button[type=submit]"));
            wait.until(ExpectedConditions.elementToBeClickable(payment));
            payment.click();
        }
    }

