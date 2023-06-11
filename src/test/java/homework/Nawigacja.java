package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Nawigacja {
    public static void main(String[] args) {

        Petent user = new Petent();
        System.out.println(user.name);


        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.className("no-account")).click();
        driver.navigate().back();
        driver.navigate().back();

        driver.close();
    }
}
