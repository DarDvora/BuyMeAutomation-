import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonWebDriver {
    private static WebDriver driver;

    //Singleton - Allow you to create a webdriver object only once
    public static WebDriver chromeWebDriver(){
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dvora.W10N-LNX-DVORAD\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

}
