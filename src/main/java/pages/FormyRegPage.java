package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormyRegPage {

    private WebDriver driver;
    private By firstNameField = By.cssSelector("#first-name");
    private By lastNameField = By.id("last-name");
    private By jobTitle = By.id("job-title");
    private By highSchool = By.id("radio-button-1");
    private By male = By.id("checkbox-1");
    private By yearsExp = By.id("select-menu");
    private By datepicker = By.id("datepicker");
    private By submit = By.cssSelector(".btn.btn-lg.btn-primary");


    public FormyRegPage(WebDriver driver){
        this.driver = driver;
    }

    public void setFirstname(){ driver.findElement(firstNameField).sendKeys("username"); }
    public void setLastname(){
        driver.findElement(lastNameField).sendKeys("Lastname");
    }
    public void setTobTitle(){
        driver.findElement(jobTitle).sendKeys("TobTitle");
    }
    public void selectHigh(){
        driver.findElement(highSchool).click();
    }
    public void selectMale(){
        driver.findElement(male).click();
    }
    public void setYears(){
        driver.findElement(yearsExp).sendKeys("5");
    }
    public void setDate(){
        driver.findElement(datepicker).sendKeys("08/24/1994");
    }
    public void submit(){
        driver.findElement(submit).click();
    }


//    public SecureAreaPage clickLoginButton(){
//        driver.findElement(loginButton).click();
//        return new SecureAreaPage(driver);
//    }
}
