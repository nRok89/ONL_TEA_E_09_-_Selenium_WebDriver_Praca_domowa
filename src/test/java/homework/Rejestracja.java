package homework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Rejestracja {


    public static void main(String[] args) {

        int numNewUser = 12;

        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");


        for ( int i=1; i<=numNewUser;i++) {
            Petent user = new Petent();

            driver.findElement(By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a")).click();
            driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/a")).click();
            driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(user.name);
            driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(user.lastName);
            driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/section/form/section/div[4]/div/input")).sendKeys(user.email);
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(user.password);
            driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys(user.birthdate);
            driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/section/form/footer/button")).click();
            driver.findElement(By.xpath("//a[@class=\"account\"]")).click();
            driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/a[2]/span")).click();
            driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/section/div[6]/div[1]/input")).sendKeys(user.adress);
            driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/section/div[9]/div[1]/input")).sendKeys(user.city);
            driver.findElement(By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a[1]")).click();
            driver.navigate().back();
            driver.navigate().back();
            System.out.println(user.email);
        }
    }
}
