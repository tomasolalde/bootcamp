package bootcamp.ejercicio1;

public class PasswordFuerte extends AbstractPassword {

    PasswordFuerte() {
        setPattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[\\\\]:;<>,.?\\\\/~_+\\-=|]).{8,32}$");
    }

    @Override
    public String getMessage() {
        return "Password invalida. \n - Al menos un caracter especial. \n - Debe contener números, mayúsculas y minúsculas. \n - Al menos 8 caracteres.";
    }
}
