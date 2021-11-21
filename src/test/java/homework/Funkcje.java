package homework;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Funkcje {


    public static void main(String[] args) {

        String firstName = "Zenon";
        String lastName = "Potrzebny";
        String email = "tfsadfasdfada@wp.pl";
        String haslo = "123BabajagaPatrzy";

        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        driver.findElement(By.className("user_login")).click();
        WebElement element = driver.findElement(By.className("is_required"));
        element.clear();
        element.sendKeys(email);

        WebElement search = driver.findElement(By.xpath("//*[@id='SubmitCreate']"));
        if (search.isEnabled()) {
            search.click();

        } else {
            Assert.fail();
        }

// strona sie ładuje i nie moża odrazu wpisywać danych
// czekam max sekunde za elementem az sie załaduje
        WebElement czekam = new WebDriverWait(driver,1)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"submitAccount\"]")));


        WebElement fName = driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
        if (fName.isDisplayed()) {
            fName.sendKeys(firstName);
        } else {
            Assert.fail("niezapisało nazwiska");
        }


        WebElement lName = driver.findElement(By.id("customer_lastname"));
        if (lName.isDisplayed()) {
            lName.sendKeys(lastName);
        } else {
            Assert.fail();
        }

        WebElement useEmail = driver.findElement(By.id("email"));
        if (useEmail.isDisplayed()) {
            useEmail.clear();
            useEmail.sendKeys(email);
        } else {
            Assert.fail();
        }

        WebElement password = driver.findElement(By.id("passwd"));
        if (password.isDisplayed()) {
            password.sendKeys(haslo);
        } else {
            Assert.fail();
        }

        WebElement button = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]"));
        if (button.isDisplayed()) {
            button.click();
        } else {
            Assert.fail();
        }

        driver.quit();

    }

}



