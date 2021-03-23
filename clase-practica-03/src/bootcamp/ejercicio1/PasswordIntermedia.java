package bootcamp.ejercicio1;

public class PasswordIntermedia extends AbstractPassword {

    PasswordIntermedia() {
        setPattern("^(?=.*[a-z])(?=.*[A-Z])(?=.*|\\d)[a-zA-Z\\d]{8,}$");
    }

    @Override
    public String getMessage() {
        return "Password invalida. \n - Al menos 8 caracteres. \n - Solo debe contener letras y números";
    }

}
