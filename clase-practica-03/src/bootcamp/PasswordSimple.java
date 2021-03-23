package bootcamp;

public class PasswordSimple extends AbstractPassword {

    PasswordSimple() {
        setPattern("^(?=.*[a-z])(?=.*|\\d)[a-z\\d]{6,}$");
    }

    @Override
    public String getMessage() {
        return "Password invalida. \n - Al menos 6 caracteres. \n - Solo debe contener letras minúsculas y números";
    }
}
