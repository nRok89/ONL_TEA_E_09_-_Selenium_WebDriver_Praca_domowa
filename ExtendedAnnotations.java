package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.pagefactory.Annotations;

import java.lang.reflect.Field;

public class ExtendedAnnotations extends Annotations {

    public ExtendedAnnotations(Field field) {
        super(field);
    }

    public static By buildBy(Field field) {
        FindBy findBy = field.getAnnotation(FindBy.class);
        if (findBy != null) {
            return buildByFindBy(findBy);
        }

        FindByDataId findByDataId = field.getAnnotation(FindByDataId.class);
        if (findByDataId != null) {
            return buildByDataId(findByDataId);
        }

        return null;
    }

    private static By buildByFindBy(FindBy findBy) {
        How how = findBy.how();
        String using = findBy.using();

        if ("".equals(using)) {
            using = null;
        }

        switch (how) {
            case CLASS_NAME:
                return By.className(using);
            case CSS:
                return By.cssSelector(using);
            case ID:
                return By.id(using);
            case ID_OR_NAME:
                return new ByIdOrName(using);
            case LINK_TEXT:
                return By.linkText(using);
            case NAME:
                return By.name(using);
            case PARTIAL_LINK_TEXT:
                return By.partialLinkText(using);
            case TAG_NAME:
                return By.tagName(using);
            case XPATH:
                return By.xpath(using);
            default:
                // Nieobsługiwane How, można dostosować według potrzeb
                return null;
        }
    }

    private static By buildByDataId(FindByDataId findByDataId) {
        String dataId = findByDataId.dataTestId();
        return By.cssSelector(String.format("[data-id='%s']", dataId));
    }
}

