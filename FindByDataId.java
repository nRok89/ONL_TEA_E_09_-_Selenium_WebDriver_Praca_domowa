package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.How;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface FindByDataId {
    String dataTestId() default "";
}