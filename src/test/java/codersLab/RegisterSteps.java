package codersLab;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

public class RegisterSteps {
    private WebDriver driver;

    @Given("przegladarka otwarta na stronie hotel-testlab.coderslab.pl")
    public void openCodersLab() {
//        RemoteWebDriver;
//        DesiredCapabilities;
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://hotel-testlab.coderslab.pl");
    }


    @When("^podajemy e-mail (.*) a nastepnie imie (.*) nazwisko (.*) i haslo (.*)$")
    public void createAccount(String email, String fname, String lname, String haslo) {
        RegisterPeges formularz = new RegisterPeges(driver);
        formularz.rejestracja(email, fname, lname, haslo);
    }

    @Then("przejscie do strony uzytkownika i potwierdzenie utworzenia konta")
    public void verification() {
        RegisterPeges potwierdzenie = new RegisterPeges(driver);
        Assert.assertEquals("Your account has been created.", potwierdzenie.accontVerification());
    }
    @And("zamknij przegladarke")
    public void closeBrowser() {
        driver.quit();

    }

}
