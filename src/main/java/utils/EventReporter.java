package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class EventReporter implements WebDriverListener {

    public void beforeClick(WebElement element) {
        System.out.println("Clicking on: " + element.getText());
    }

    public void afterClick(WebElement element) {
        System.out.println("Clicked on: " + element.getText());
    }

    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.println("Finding element: " + locator);
    }

    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        System.out.println("Found element: " + locator);
    }

    public void onError(WebDriver driver, Throwable throwable) {
        System.out.println("Exception occurred: " + throwable.getMessage());
    }
}
