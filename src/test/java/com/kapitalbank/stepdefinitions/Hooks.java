package com.kapitalbank.stepdefinitions;

import com.kapitalbank.utilities.BrowserUtils;
import com.kapitalbank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {
    @Before
    public void setupMethod() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @After
    public void teardownMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        BrowserUtils.sleep(5);
        Driver.closeDriver();
    }





}
