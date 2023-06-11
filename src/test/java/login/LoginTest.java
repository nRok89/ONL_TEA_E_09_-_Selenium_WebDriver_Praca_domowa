package login;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;


import java.util.concurrent.TimeUnit;

public class LoginTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void createUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.singIn("hotel.test@coders.com", "Bartek", "Wola", "hasloHotelu123");
        Assert.assertEquals("Your account has been created.", loginPage.accontCreated());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}