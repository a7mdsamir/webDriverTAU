package login;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FormyRegPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class FormyTests  {

    private WebDriver driver;
    protected FormyRegPage formyRegPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");
        driver.manage().window().maximize();

        formyRegPage = new FormyRegPage(driver);
    }
    @Test
    public void testSuccessfulReg(){
        FormyRegPage formyRegPage = new FormyRegPage(driver);
        formyRegPage.setFirstname();
        formyRegPage.setLastname();
        formyRegPage.setTobTitle();
        formyRegPage.selectHigh();
        formyRegPage.selectMale();
        formyRegPage.setYears();
        formyRegPage.setDate();
        formyRegPage.submit();

    }
}
