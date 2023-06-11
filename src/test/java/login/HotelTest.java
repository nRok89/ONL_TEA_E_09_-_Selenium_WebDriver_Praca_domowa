package login;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.HotelSearchPage;
import pages.LoginHotelPage;


import java.util.concurrent.TimeUnit;

public class HotelTest {
    private static WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }
    @Test
    public void hotelSearch () {

        String email = "hotel.test@coders.com";
        String password = "hasloHotelu123";
        String userName = "Bartek";

        LoginHotelPage userLogin = new LoginHotelPage(driver);
        userLogin.singIn(email, password);
        Assert.assertEquals(userName, userLogin.user());

        HotelSearchPage hotelSearch = new HotelSearchPage(driver);
        hotelSearch.hotelDominic("Warszawa","30-11-2023","8-12-2023");
        //Assert.assertEquals("Delux Rooms", hotelSearch.roomAdd());
        Assert.assertTrue(hotelSearch.roomAdd());
    }

    @After
    public void po³¹czenie() {

        driver.quit();
    }
}


