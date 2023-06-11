package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {



    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".user_login")
    private WebElement singInButton;


    @FindBy(xpath = "//*[@id=\"email_create\"]")
    private WebElement poleEmail;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]")
    private WebElement submitCreate;

    @FindBy(xpath = "//*[@id=\"customer_firstname\"]")
    private WebElement fName;

    @FindBy(id = "customer_lastname")
    private WebElement lName;

    @FindBy(id = "email")
    private WebElement useEmail;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"submitAccount\"]")
    private WebElement register;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/p[1]")
    private WebElement accontCreatedText;




    public void singIn(String email, String name, String sName, String haslo) {
        singInButton.click();
        writeDate(poleEmail,email);
        submitCreate.click();


        fName.sendKeys(name);
        lName.sendKeys(sName);
        useEmail.clear();
        useEmail.sendKeys(email);
        password.click();
        password.sendKeys(haslo);
        register.click();


    }

    public String accontCreated() {
        return accontCreatedText.getText();

    }

    public void writeDate(WebElement input, String text){
        input.click();
        input.clear();
        input.sendKeys(text);
    }


}
