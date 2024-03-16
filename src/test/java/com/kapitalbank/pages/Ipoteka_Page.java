package com.kapitalbank.pages;

import com.kapitalbank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ipoteka_Page {

    Actions actions = new Actions(Driver.getDriver());

    public Ipoteka_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = ":r0:")
    public WebElement iptkaDpn;

    @FindBy(id = ":r5:")
    public WebElement marriageStatusDpn;

    @FindBy(xpath = "//button[@type='submit']//span[.='Müraciət et']/..")
    public WebElement submitBtn;


    public void setIpotekaType(String ipotekaType) {

        Driver.getDriver().findElement(By.xpath("//div[.='" + ipotekaType + "']")).click();
    }

    public void setIncome(String incomeType) {

        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//div[.='" + incomeType + "']"))).click().perform();
    }

    public void setInputBox(String expectedInputBox, String value) {

        WebElement inputBox = Driver.getDriver().findElement(By.xpath("//label[.='" + expectedInputBox + "']/.."));
        actions.moveToElement(inputBox).click().sendKeys(value).perform();
    }

    public void setMarriageStatus(String marriageStatus) {

        actions.moveToElement(marriageStatusDpn).click().perform();
        Driver.getDriver().findElement(By.xpath("//div[.='" + marriageStatus + "']")).click();
    }

    public Boolean errorMessage(String expectedMessage) {

        WebElement actualError = Driver.getDriver().findElement(By.xpath("//p[.='" + expectedMessage + "']"));
        String error = actualError.getText();
        System.out.println("Error Message: " + error);
        return actualError.isDisplayed();
    }


}