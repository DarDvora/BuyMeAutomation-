import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PickBusiness {
    private WebDriver driver;

    public PickBusiness (){this.driver = SingletonWebDriver.chromeWebDriver();}
    WebDriverWait wait = new WebDriverWait(SingletonWebDriver.chromeWebDriver(), Duration.ofSeconds(10));

    public void businessSelection() throws InterruptedException {
        pickBusiness();
        insertAmount();
    }

    public void pickBusiness () throws InterruptedException {
        Thread.sleep(5000);
        WebElement TevaNaot = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/ul/div[7]/a"));
        wait.until(ExpectedConditions.elementToBeClickable(TevaNaot));
        TevaNaot.click();
    }

    public void insertAmount() throws InterruptedException {
        Thread.sleep(10000);
        WebElement insertAmount = driver.findElement(By.cssSelector("input[type=tel]"));
        Thread.sleep(5000);
        insertAmount.sendKeys("500");

        WebElement selectionButton = driver.findElement(By.className("money-btn"));
        wait.until(ExpectedConditions.elementToBeClickable(selectionButton)).click();
    }
}
