import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class BuyMeSanityTest {
    private static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(SingletonWebDriver.chromeWebDriver(), Duration.ofSeconds(10));

    //reference to singleton webDriver
    public BuyMeSanityTest() {driver = SingletonWebDriver.chromeWebDriver();}
    IntroRegistration introRegistration = new IntroRegistration();
    HomeScreen homeScreen = new HomeScreen();
    PickBusiness pickBusiness = new PickBusiness();
    InformationScreen informationScreen = new InformationScreen();
    SendInformation sendInformation= new SendInformation();

    @BeforeClass
    public void beforeClass() {
        introRegistration.entrance();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
        @Test(priority = 1)
        public void getRegisterScreen () {
          introRegistration.getRegisterScreen();
        }

        @Test(priority = 3)
        public void giftSelectionDetails () throws InterruptedException {
        Thread.sleep(10000);
            homeScreen.giftSelectionDetails();

        }

        @Test(priority = 5)
        public void assertURL () {
            //Thread.sleep(10000);
            String URL = "https://buyme.co.il/search?budget=3&category=204&region=9";
            Assert.assertEquals(driver.getCurrentUrl(), URL);

        }
        @Test(priority = 6)
        public void pickBusiness () throws InterruptedException {
        Thread.sleep(10000);
            pickBusiness.businessSelection();
        }

        @Test (priority = 7)
    public void informationScreen () throws InterruptedException {
        informationScreen.senderAndReceiverInformation();
            }

            @Test (priority = 8)
    public void SendInformation() throws InterruptedException {
        sendInformation.informationToPayment();
            }


        }


















