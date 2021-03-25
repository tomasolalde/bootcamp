package factorySort;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MyFactory {

    public static Object getInstance(String objName) {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("MyFactory.properties"));
            String className = properties.getProperty(objName);
            return Class.forName(className).getConstructor().newInstance();
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }
}


