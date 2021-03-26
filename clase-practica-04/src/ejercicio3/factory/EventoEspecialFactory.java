package ejercicio3.factory;

import ejercicio3.product.Evento;
import ejercicio3.product.EventoEspecial;

public class EventoEspecialFactory implements EventoFactory {

    @Override
    public Evento crearEvento() {
        return new EventoEspecial();
    }
}
