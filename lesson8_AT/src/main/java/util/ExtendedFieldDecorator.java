package util;

import custom.Element;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ExtendedFieldDecorator extends DefaultFieldDecorator {

    public ExtendedFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    public ExtendedFieldDecorator(SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (Element.class.isAssignableFrom(field.getType())) {
            return decorateElement(loader, field);
        }

        return super.decorate(loader, field);
    }

    private Object decorateElement(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        return create((Class<? extends Element>) field.getType(), wrappedElement);
    }

    private ElementLocator createLocator(final Field field) {
        return factory.createLocator(field);
    }

    public <E extends Element> E create(final Class<E> elementClass, final WebElement wrappedElement) {
        try {
            return findImplementationFor(elementClass)
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private <E extends Element> Class<? extends E> findImplementationFor(final Class<E> elementClass) {
        try {
            return (Class<? extends E>) Class.forName(String.format("%s.%sImpl", elementClass.getPackage().getName(), elementClass.getSimpleName()));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}