package bootcamp.ejercicio1;

import java.util.InvalidPropertiesFormatException;
import java.util.regex.Pattern;

public abstract class AbstractPassword {

    private String password;
    protected Pattern pattern;

    public void setValue(String password) throws InvalidPropertiesFormatException {
        boolean result = pattern.matcher(password).matches();
        if (!result) {
            throw new InvalidPropertiesFormatException(getMessage());
        }
        this.password = password;
    }

    public abstract String getMessage();

    public String getPassword() {
        return password;
    }

    public void setPattern(String regex) {
        this.pattern = Pattern.compile(regex);
    }
}
