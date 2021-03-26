package ejercicio3.product;

import ejercicio3.factory.InvitadoFactory;
import ejercicio3.product.FuegoArtificial;

public interface Evento {
    void reventarLaParty(String fraseElocuenteQueDaInicioALaParty);
    void agrgarFuegosArtificiales(FuegoArtificial fuegoArtificial);
    void agregarInvitado(Invitado invitado);
    void mostrarInvitados();
}
