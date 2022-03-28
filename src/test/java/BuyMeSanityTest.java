import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class BuyMeSanityTest {
    private static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(SingletonWebDriver.chromeWebDriver(), Duration.ofSeconds(10));

    //reference to singleton webDriver
    //public BuyMeSanityTest() {driver = SingletonWebDriver.chromeWebDriver();}
    IntroRegistration introRegistration = new IntroRegistration();
    HomeScreen homeScreen = new HomeScreen();
    PickBusiness pickBusiness = new PickBusiness();
    InformationScreen informationScreen = new InformationScreen();
    SendInformation sendInformation= new SendInformation();
    private static ExtentReports extent;
    private static ExtentTest test;
    String timeNow = String.valueOf(System.currentTimeMillis());

    @BeforeClass
    public void beforeClass() throws Exception {
        String cwd = System.getProperty("user.dir");

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html" + (dateFormat.format(date)));

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("first report", "sample description");
        //log results
        test.log(Status.INFO, "@BeforeClass");

        try {
            driver = SingletonWebDriver.chromeWebDriver();
            introRegistration.entrance();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            test.log(Status.PASS, "Driver established successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Driver connection failed! " + e.getMessage());
            throw new Exception("Driver failed");
        }
    }

        @Test(priority = 1)
        public void getRegisterScreen () {
        try {
            introRegistration.getRegisterScreen();
            test.pass("Registration was successful");
        }catch (Exception e){
            e.printStackTrace();
            test.fail("Registration failed"+ e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(BasePage.takeScreenShot(timeNow)).build());
        }
        }

        @Test(priority = 2)
        public void giftSelectionDetails () throws InterruptedException {
        try {
            Thread.sleep(10000);
            homeScreen.giftSelectionDetails();
            test.pass("Selection gift details was successful");
        }catch (Exception e){
            e.printStackTrace();
            test.fail("Selection gift details failed"+ e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(BasePage.takeScreenShot(timeNow)).build());
        }
        }

        @Test(priority = 3)
        public void assertURL () {
           try {
               String URL = "https://buyme.co.il/search?budget=3&category=204&region=9";
               Assert.assertEquals(driver.getCurrentUrl(), URL);
               test.pass("Assert URL was successful");
           }catch (Exception e){
               e.printStackTrace();
               test.fail("Assert URL failed"+ e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(BasePage.takeScreenShot(timeNow)).build());
           }

        }
        @Test(priority = 4)
        public void pickBusiness () throws InterruptedException {
        try {
            Thread.sleep(10000);
            pickBusiness.businessSelection();
            test.pass("Pick business was successful");
        }catch (Exception e){
            e.printStackTrace();
            test.fail("Pick business failed"+ e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(BasePage.takeScreenShot(timeNow)).build());
        }
        }

        @Test (priority = 5)
    public void informationScreen () throws InterruptedException {
        try{
            informationScreen.senderAndReceiverInformation();
            test.pass("Sender And Receiver Information was successful");
        }catch (Exception e){
            e.printStackTrace();
            test.fail("Pick business failed"+ e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(BasePage.takeScreenShot(timeNow)).build());
        }
            }

            @Test (priority = 6)
    public void SendInformation() throws InterruptedException {
        try {
            sendInformation.informationToPayment();
            test.pass("Information for payment was successful");
        }catch (Exception e){
            e.printStackTrace();
            test.fail("Information for payment"+ e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(BasePage.takeScreenShot(timeNow)).build());
        }
            }

            @AfterClass
    public static void afterClass(){
        test.log(Status.INFO, "@After test"+"After test method");
        driver.quit();
        extent.flush();
            }
        }
