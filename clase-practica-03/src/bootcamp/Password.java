package bootcamp;

import java.util.regex.Pattern;

public class Password {

    private String password;
    private String message = "Invalid password \n - Minimum eight characters" +
            " - At least one uppercase letter\n" +
            " - At least one lowercase letter\n" +
            " - At least one number\n" +
            " - At least one special character";
    private final Pattern pattern;

    Password(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public void setValue(String password) throws IllegalArgumentException {
        if (!pattern.matcher(password).matches()) {
            throw new IllegalArgumentException(message);
        }
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPassword() {
        return password;
    }
}
