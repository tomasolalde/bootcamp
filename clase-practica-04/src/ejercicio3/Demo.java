package ejercicio3;

import ejercicio3.factory.*;
import ejercicio3.product.Evento;
import ejercicio3.product.EventoEspecial;
import ejercicio3.product.FuegoArtificial;
import ejercicio3.product.FuegoArtificialPack;

public class Demo {
    public static void main(String[] args) {
        // Fuegos artificiales factory
        FuegoArtificialPAMFactory fuegoArtificialPAMFactory = new FuegoArtificialPAMFactory();
        FuegoArtificialPUFFactory fuegoArtificialPUFFactory = new FuegoArtificialPUFFactory();
        FuegoArtificialPUMFactory fuegoArtificialPUMFactory = new FuegoArtificialPUMFactory();
        FuegoArtificialPackFactory fuegoArtificialPackFactory = new FuegoArtificialPackFactory();
        // Invitados factory
        InvitadoNormalFactory invitadoNormalFactory = new InvitadoNormalFactory();
        InvitadoMeliFactory invitadoMeliFactory = new InvitadoMeliFactory();
        // Evento factory
        EventoEspecialFactory eventoEspecialFactory = new EventoEspecialFactory();
        Evento eventoEspecial = eventoEspecialFactory.crearEvento();

        FuegoArtificial fuegoPUM = fuegoArtificialPUMFactory.crearFuegoArtificial();
        FuegoArtificial fuegoPUF = fuegoArtificialPUFFactory.crearFuegoArtificial();
        FuegoArtificial fuegoPAM = fuegoArtificialPAMFactory.crearFuegoArtificial();
        FuegoArtificialPack fuegoPack = (FuegoArtificialPack) fuegoArtificialPackFactory.crearFuegoArtificial();
        fuegoPack.agregarFuegoArtificialPUM();
        fuegoPack.agregarFuegoArtificialPAM();
        fuegoPack.agregarFuegoArtificialPAM();
        fuegoPack.agregarFuegoArtificialPUF();

        eventoEspecial.agregarInvitado(invitadoMeliFactory.crearInvitado());
        eventoEspecial.agregarInvitado(invitadoNormalFactory.crearInvitado());
        eventoEspecial.mostrarInvitados();

        eventoEspecial.agrgarFuegosArtificiales(fuegoPUM);
        eventoEspecial.agrgarFuegosArtificiales(fuegoPUF);
        eventoEspecial.agrgarFuegosArtificiales(fuegoPAM);
        eventoEspecial.agrgarFuegosArtificiales(fuegoPack);

        eventoEspecial.reventarLaParty("Viva La Chiqui!");
    }
}
