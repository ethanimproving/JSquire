package framework.utility;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {

    public static <T> void setField(String fieldName, T value, Object target) {
        String methodName = String.format("set%s", StringUtils.capitalize(fieldName));
        try {
            Method method = target.getClass().getDeclaredMethod(methodName, value.getClass());
            method.setAccessible(true);
            method.invoke(target, value);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new InjectorException(e);
        }
    }

    public static Object callMethodByName(String methodName, Object target) {
        try {
            Method method = target.getClass().getDeclaredMethod(methodName);
            method.setAccessible(true);
            return method.invoke(target);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new InjectorException(e);
        }
    }

    public static class InjectorException extends RuntimeException {
        public InjectorException(Exception e) {
            super(e);
        }
    }

}
