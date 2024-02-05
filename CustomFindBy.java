package baseCommends;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CustomFindBy {

    public static WebElement initElements(CustomFindByFactory factory, Class<?> pageClassToProxy) {
        return (WebElement) Proxy.newProxyInstance(
                pageClassToProxy.getClassLoader(), new Class[]{WebElement.class},
                new CustomHandler(factory)
        );
    }

    public static class CustomFindByFactory {
        public By buildByWithCustomFindBy(FindBy findBy) {
            return buildBy(findBy);
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
                // np. driver.findElement(by).click();
            }
            return null;
        }
    }

    @Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    @Target({java.lang.annotation.ElementType.FIELD})
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

    // Przyk³ad u¿ycia
    public class YourPageObject {

        @CustomFindBy(testId = "username")
        private WebElement usernameField;

        public YourPageObject() {
            CustomFindByFactory factory = new CustomFindByImpl();
            WebElement element = CustomFindBy.initElements(factory, YourPageObject.class);
            // Tutaj mo¿esz korzystaæ z elementu, np. element.click();
        }
    }
}

