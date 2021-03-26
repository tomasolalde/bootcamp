package ejercicio3.factory;

import ejercicio3.product.FuegoArtificial;
import ejercicio3.product.FuegoArtificialPUM;

public class FuegoArtificialPUMFactory implements FuegoArtificialFactory {
    @Override
    public FuegoArtificial crearFuegoArtificial() {
        return new FuegoArtificialPUM();
    }
}
