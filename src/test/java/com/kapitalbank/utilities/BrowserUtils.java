package com.kapitalbank.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {



    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle) {

        Set<String> allHandles = Driver.getDriver().getWindowHandles();
        for (String each : allHandles) {
            Driver.getDriver().switchTo().window(each);

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }


    public static void verifyTitleContains(WebDriver driver, String expectedTitle) {
        // String actualTitle = driver.getTitle();
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }

    public static void verifyTitleEquals(String expectedTitle) {
        // String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    public static void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }


    public static void clickOption(WebDriver driver, String option) {

        driver.findElement(By.linkText(option)).click();// option = checkboxes,dropdown


    }

    public static List<String> dropdownOptions_as_String(WebElement dropdownElement) {

        Select select = new Select(dropdownElement);

        List<WebElement> actualMonthsAsWebElement = select.getOptions();
        List<String> actualMonthsAsString = new ArrayList<>();
        for (WebElement each : actualMonthsAsWebElement) {
            actualMonthsAsString.add(each.getText());
        }
        return actualMonthsAsString;
    }

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {

        for (WebElement eachButton : radioButtons) {
            if (eachButton.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                eachButton.click();
            }
        }
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static List<String> getElementsText(List<WebElement> list) {

        List<String> elemTexts = new ArrayList<>();
        for (WebElement each : list) {
            elemTexts.add(each.getText());
        }
        return elemTexts;
    }

    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement each : elems) {
            elemTexts.add(each.getText());
        }
        return elemTexts;
    }


    public static void waitForVisibility(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForVisibility(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForClickability(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForClickability(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable (locator));
    }


}
