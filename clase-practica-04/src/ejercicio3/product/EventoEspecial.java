package ejercicio3.product;

import java.util.ArrayList;

public class EventoEspecial implements Evento {

    ArrayList<FuegoArtificial> fuegosArtificiales = new ArrayList<FuegoArtificial>();
    ArrayList<Invitado> listaDeInvitados = new ArrayList<Invitado>();

    @Override
    public void reventarLaParty(String fraseElocuenteQueDaInicioALaParty) {
        System.out.println("\n" + "   " + fraseElocuenteQueDaInicioALaParty + "\n");
        for (FuegoArtificial fuegoArtificial : fuegosArtificiales) {
            fuegoArtificial.explotar();
        }
    }

    @Override
    public void agrgarFuegosArtificiales(FuegoArtificial fuegoArtificial) {
        fuegosArtificiales.add(fuegoArtificial);
    }

    @Override
    public void agregarInvitado(Invitado invitado) {
        listaDeInvitados.add(invitado);
    }

    @Override
    public void mostrarInvitados() {
        System.out.println("\nLista de invitados.\n");
        for(Invitado invitado: listaDeInvitados) System.out.println(invitado);;
    }
}
