package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://coderslab.pl/pl");

        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        driver.quit();
    }
}
