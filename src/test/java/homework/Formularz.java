package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Formularz {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");

        driver.findElement(By.id("first-name")).sendKeys("Karol");
        driver.findElement(By.id("last-name")).sendKeys("Kowalski");
        driver.findElement(By.xpath("/html/body/div/div/form/div[3]/div/div/label[1]/input")).click();
        driver.findElement(By.id("dob")).sendKeys("05/22/2010");
        driver.findElement(By.id("email")).sendKeys("karol.kowalski@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("Pass123");
        driver.findElement(By.id("company")).sendKeys("Coders Lab");
        driver.findElement(By.id("comment")).sendKeys("To jest mój pierwszy automat testowy");
        driver.findElement(By.xpath("/html/body/div/div/form/div[9]/div/select/option[3]")).click();
        driver.findElement(By.xpath("/html/body/div/div/form/div[10]/div/select/option[2]")).click();


        driver.findElement(By.id("submit")).click();

    }


}
