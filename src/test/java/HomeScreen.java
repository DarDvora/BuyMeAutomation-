import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HomeScreen extends BasePage {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(SingletonWebDriver.chromeWebDriver(), Duration.ofSeconds(10));

    public HomeScreen (){ this.driver = SingletonWebDriver.chromeWebDriver();}
    public void giftSelectionDetails(){
        amountDropdown();
        areaDropdown();
        categoryDropdown();
        search();
    }

    public void amountDropdown(){

        WebElement amount = getWebElement(By.cssSelector("span[alt=סכום]"));
        wait.until(ExpectedConditions.elementToBeClickable(amount));
        amount.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1066"))).click();
    }

    public void areaDropdown () {
        WebElement area = getWebElement(By.cssSelector("span[alt=אזור]"));
        wait.until(ExpectedConditions.elementToBeClickable(area));
        area.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1101"))).click();
    }

    public void categoryDropdown(){
        WebElement category = getWebElement(By.cssSelector("span[alt=קטגוריה]"));
        wait.until(ExpectedConditions.elementToBeClickable(category));
        category.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1161"))).click();
    }

    public void search(){
        clickElement(By.id("ember1188"));
    }
}
