import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class CustomFindByExample {

    // Statyczna instancja WebDrivera
    private static WebDriver driver;

    public static void main(String[] args) {
        // Inicjalizacja WebDrivera (pamiêtaj o dostosowaniu œcie¿ki do sterownika przegl¹darki)
        System.setProperty("webdriver.chrome.driver", "œcie¿ka/do/sterownika/chromedriver.exe");
        driver = new ChromeDriver();

        // Tworzenie obiektu klasy YourPageObject
        YourPageObject pageObject = new YourPageObject();

        // Wywo³anie metody na elemencie
        pageObject.performSomeAction();

        // Zamkniêcie przegl¹darki
        driver.quit();
    }

    public static class CustomFindByFactory {
        public By buildByWithCustomFindBy(FindBy findBy) {
            return buildByFromFindBy(findBy);
        }
    }

    public static class CustomHandler implements InvocationHandler {
        private final CustomFindByFactory factory;

        public CustomHandler(CustomFindByFactory factory) {
            this.factory = factory;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            FindBy findBy = method.getAnnotation(FindBy.class);
            if (findBy != null) {
                By by = factory.buildByWithCustomFindBy(findBy);
                // Dodaj tutaj kod obs³ugi WebDrivera i wyszukiwania elementu
                WebElement element = driver.findElement(by);
                // Wykonaj odpowiednie operacje na elemencie, np. element.click();
            }
            return null;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface CustomFindBy {
        String testId() default "";

        String css() default "";
    }

    public static class CustomFindByImpl extends CustomFindByFactory {
        @Override
        public By buildByWithCustomFindBy(FindBy findBy) {
            CustomFindBy customFindBy = ((Field) findBy.getClass().getDeclaredFields()[0]).getAnnotation(CustomFindBy.class);
            if (customFindBy != null && !customFindBy.testId().isEmpty()) {
                return By.cssSelector("[test-id='" + customFindBy.testId() + "']");
            } else {
                return super.buildByWithCustomFindBy(findBy);
            }
        }
    }

    public static class YourPageObject {

        @CustomFindBy(testId = "username")
        private WebElement usernameField;

        private CustomFindByFactory factory;

        public YourPageObject() {
            this.factory = new CustomFindByImpl();
            CustomFindBy.initElements(factory, this);
        }

        public WebElement getUsernameField() {
            return usernameField;
        }

        public void performSomeAction() {
            // Przyk³adowa akcja na elemencie
            getUsernameField().click();
        }
    }
}
