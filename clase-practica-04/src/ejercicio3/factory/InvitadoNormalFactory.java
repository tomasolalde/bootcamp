package ejercicio3.factory;

import ejercicio3.product.Invitado;
import ejercicio3.product.InvitadoNormal;

public class InvitadoNormalFactory implements InvitadoFactory{

    @Override
    public Invitado crearInvitado() {
        return new InvitadoNormal();
    }
}
