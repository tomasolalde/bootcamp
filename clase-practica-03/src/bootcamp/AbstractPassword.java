package bootcamp;

import java.util.regex.Pattern;

public abstract class AbstractPassword {

    private String password;
    protected Pattern pattern;

    public void setValue(String password) throws IllegalArgumentException {
        boolean result = pattern.matcher(password).matches();
        if (!result) {
            throw new IllegalArgumentException(getMessage());
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
