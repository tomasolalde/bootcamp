package ejercicio3.factory;

import ejercicio3.product.InvidatoMeli;
import ejercicio3.product.Invitado;

public class InvitadoMeliFactory implements InvitadoFactory{
    @Override
    public Invitado crearInvitado() {
        return new InvidatoMeli();
    }
}
