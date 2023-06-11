package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XpathFinder {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl//index.php?controller=authentication&create_account=1");

        driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/section/form/section/div/div/label/span/input")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Jan");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Niezbędny");
        driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/section/form/section/div[4]/div/input")).sendKeys("jan.niezbedny@oko.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123852456dasdfWDf");
        driver.findElement(By.xpath("//button[@data-action='show-password']")).click();
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("31/02/1999");

        driver.close();


    }



}
