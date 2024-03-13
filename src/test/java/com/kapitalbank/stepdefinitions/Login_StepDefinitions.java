package com.kapitalbank.stepdefinitions;

import com.kapitalbank.utilities.ConfigurationReader;
import com.kapitalbank.utilities.Driver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_StepDefinitions {

    @Given("the user is logged in")
    public void the_user_is_logged_in() throws InterruptedException {
       // https://ipoteka.kapitalbank.az/?tvr_id=ef750651-561e-41a6-a083-b58ca2e7cbdd
        Driver.getDriver().get("https://ipoteka.kapitalbank.az/");//ConfigurationReader.getProperty("kapitalbank.url")
        Driver.getDriver().findElement(By.xpath("//button[@type='button']//span[.='Müraciət et']")).click();

        //button[@type='button']//span[.='Müraciət et']

        //  Thread.sleep(3000);
     //  WebElement verify = Driver.getDriver().findElement(By.xpath("//label[@class='ctp-checkbox-label']//input[@type='checkbox']"));
     //   verify.click();

     //  WebElement sign = Driver.getDriver().findElement(By.linkText("Kapital Bank"));
     //   WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
     //   wait.until(ExpectedConditions.visibilityOf(sign));

    //b[contains(text()='Yüksəlmiş faizlə ')


// headers of input boxes in opeteka //label[@class='jIMTOxJRV3puEeWgHmx--g==']

    }















}
