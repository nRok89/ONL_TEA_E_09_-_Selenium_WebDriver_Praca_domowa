package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExamplePage {

    @FindByDataId(dataTestId = "exampleId")
    private WebElement exampleElement;

    public void performAction() {
        exampleElement.click();
    }
}