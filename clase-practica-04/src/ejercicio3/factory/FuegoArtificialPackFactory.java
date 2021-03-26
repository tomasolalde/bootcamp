package ejercicio3.factory;

import ejercicio3.product.FuegoArtificial;
import ejercicio3.product.FuegoArtificialPack;

public class FuegoArtificialPackFactory implements FuegoArtificialFactory {
    @Override
    public FuegoArtificial crearFuegoArtificial() {
        return new FuegoArtificialPack();
    }
}
