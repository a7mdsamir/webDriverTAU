package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.CookieManager;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {

//    private EventFiringDecorator driver;
    private WebDriver driver;  // ✅ Use WebDriver instead
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        WebDriver baseDriver = new ChromeDriver(getChromeOptions());  // Instantiate base WebDriver
        WebDriverListener eventListener = new EventReporter();  // Event listener

        // Wrap baseDriver (not null) instead of driver (which is still null)
        driver = new EventFiringDecorator<>(eventListener).decorate(baseDriver);
//        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the browser window
//        setCookie();
    }


    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
//        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);  // ✅ Update WindowManager to accept WebDriver
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");

//        options.addArguments("--headless=new");  // Use this instead of setHeadless(true)
        options.addArguments("--disable-gpu");   // Helps with some OS issues
//        options.addArguments("--window-size=1920,1080"); // Ensure full viewport size
        return options;
    }

    public CookieManager getCookieManager(){
        return new CookieManager(driver);

    }

    private void setCookie() {
        driver.get("https://the-internet.herokuapp.com");
        // Create the cookie
        Cookie cookie = new Cookie.Builder("tau", "123")
//                .domain("the-internet.herokuapp.com")
                .path("/")  // Ensure it applies to all paths
                .isHttpOnly(true)  // Optional: Secure cookie settings
                .build();

        // Add the cookie to the browser
        driver.manage().addCookie(cookie);

        // Verify the cookie was set
        System.out.println("Cookie set: " + driver.manage().getCookieNamed("tau"));

    }
}
