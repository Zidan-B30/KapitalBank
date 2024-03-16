package com.kapitalbank.stepdefinitions;

import com.kapitalbank.pages.Ipoteka_Page;
import com.kapitalbank.utilities.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.interactions.Actions;

public class Ipoteka_StepDefinitions {
    Ipoteka_Page ipotekaPage = new Ipoteka_Page();
    Actions actions = new Actions(Driver.getDriver());

    @When("the user is logged in ipotekalar module")
    public void the_user_is_logged_in_ipotekalar_module() {

        Driver.getDriver().get(ConfigurationReader.getProperty("kapitalbank.url"));
    }

    @And("the user selects {string} from Ipoteka növü drop down")
    public void the_user_selects_from_Ipoteka_növü_drop_down(String ipotekaType) {

        actions.moveToElement(ipotekaPage.iptkaDpn).click().perform();
        ipotekaPage.setIpotekaType(ipotekaType);
    }


    @And("the user enters {string} in FIN kod box")
    public void the_user_enters_in_FIN_kod_box(String finKod) {

        ipotekaPage.setInputBox("FİN kod", finKod);
    }

    @And("the user enters {string} in Mobil nömrə box")
    public void the_user_enters_in_Mobil_nömrə_box(String phoneNumber) {

        ipotekaPage.setInputBox("Mobil nömrə", phoneNumber);
    }

    @And("the user selects {string} from Ailə vəziyyəti drop down")
    public void the_user_selects_from_Ailə_vəziyyəti_drop_down(String marriageStatus) {

        ipotekaPage.setMarriageStatus(marriageStatus);
    }

    @And("the user enters {string} in Ailə üzvlərin sayı box")
    public void the_user_enters_in_Ailə_üzvlərin_sayı_box(String familyCount) {

        ipotekaPage.setInputBox("Ailə üzvlərin sayı", familyCount);
    }

    @And("the user enters {string} in Digər xərclər və öhdəliklər box")
    public void the_user_enters_in_Digər_xərclər_və_öhdəliklər_box(String costs) {

        ipotekaPage.setInputBox("Digər xərclər və öhdəliklər", costs);
    }

    @When("the user clicks {string} and {string} in the checkbox")
    public void the_user_clicks_and_in_the_checkbox(String profit1, String profit2) {

        ipotekaPage.setIncome(profit1);
        ipotekaPage.setIncome(profit2);
    }

    @And("the user enters {string} in VÖEN box")
    public void the_user_enters_in_VÖEN_box(String nums) {

        ipotekaPage.setInputBox("VÖEN", nums);
    }

    @And("the user enters {string} in Orta aylıq xalis mənfəət \\(₼) box")
    public void the_user_enters_in_orta_aylıq_xalis_mənfəət_₼_box(String amount) {

        ipotekaPage.setInputBox("Orta aylıq xalis mənfəət (₼)", amount);
    }

    @And("the user enters {string} in Fəaliyyət müddəti box")
    public void the_user_enters_in_Fəaliyyət_müddəti_box(String time) {

        ipotekaPage.setInputBox("Fəaliyyət müddəti, ay", time);
    }


    @And("the user clicks on submit button")
    public void the_user_clicks_on_submit_button() {

        actions.moveToElement(ipotekaPage.submitBtn).click().perform();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        ipotekaPage.errorMessage("Zəhmət olmasa, şəxsiyyət vəsiqənizin FİN kodunu daxil edin");
        ipotekaPage.errorMessage("Zəhmət olmasa, mobil nömrəni düzgün daxil edin");
        ipotekaPage.errorMessage("Zəhmət olmasa, ailə üzvlərinin sayını düzgün daxil edin");
        ipotekaPage.errorMessage("Zəhmət olmasa, VÖEN nömrəsini düzgün daxil edin");
        ipotekaPage.errorMessage("Zəhmət olmasa, orta aylıq xalis mənfəəti düzgün daxil edin");
        ipotekaPage.errorMessage("Zəhmət olmasa, müddəti düzgün daxil edin");
    }


}
