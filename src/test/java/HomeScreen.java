import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HomeScreen extends BasePage {
    private WebDriver driver = SingletonWebDriver.getInstance();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public HomeScreen (){ this.driver = SingletonWebDriver.getInstance();}
    public void giftSelectionDetails(){
        amountDropdown();
        areaDropdown();
        categoryDropdown();
        search();
    }
    //selecting amount range from dropdown
    public void amountDropdown(){
        WebElement amount = getWebElement(By.cssSelector("span[alt=סכום]"));
        wait.until(ExpectedConditions.elementToBeClickable(amount));
        amount.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1066"))).click();
    }
    //selection geographical area from dropdown
    public void areaDropdown () {
        WebElement area = getWebElement(By.cssSelector("span[alt=אזור]"));
        wait.until(ExpectedConditions.elementToBeClickable(area));
        area.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1101"))).click();
    }
    //selection category from dropdown
    public void categoryDropdown(){
        WebElement category = getWebElement(By.cssSelector("span[alt=קטגוריה]"));
        wait.until(ExpectedConditions.elementToBeClickable(category));
        category.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1161"))).click();
    }
    //search button
    public void search(){
        clickElement(By.id("ember1188"));
    }
}
