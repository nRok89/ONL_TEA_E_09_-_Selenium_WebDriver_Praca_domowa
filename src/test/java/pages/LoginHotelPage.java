package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginHotelPage {

    private WebDriver driver;

    @FindBy(css = ".user_login")
    private WebElement singInButton;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwardInput;

    @FindBy(id = "SubmitLogin")
    private WebElement SubmitLoginInput;

    @FindBy (xpath = "/html/body/div/div[2]/div/div[2]/div/ul/li/a")
    private WebElement homeButtom;


    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[7]/ul/li/button/span[1]")
    private WebElement nameUserText;






    public LoginHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void singIn(String email, String passward){

        singInButton.click();
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        passwardInput.click();
        passwardInput.clear();
        passwardInput.sendKeys(passward);
        SubmitLoginInput.click();
        homeButtom.click();
    }

    public String user() {
        return nameUserText.getText();
    }


    public void hotelSerch(String city){


    }


}
