package codersLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPeges {

    public RegisterPeges(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "user_login")
    private WebElement singIn;
    @FindBy(className = "is_required")
    private WebElement emailAddres;
    @FindBy(id = "SubmitCreate")
    private WebElement creatBot;

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


    public void rejestracja(String email, String name, String sName, String haslo) {
        singIn.click();
        emailAddres.click();
        emailAddres.clear();
        emailAddres.sendKeys(email);
        creatBot.click();

        fName.sendKeys(name);
        lName.sendKeys(sName);
        useEmail.clear();
        useEmail.sendKeys(email);
        password.click();
        password.sendKeys(haslo);
        register.click();

    }

    public String accontVerification() {
        return accontCreatedText.getText();


    }
}