package ejercicio3.factory;

import ejercicio3.product.FuegoArtificial;
import ejercicio3.product.FuegoArtificialPAM;

public class FuegoArtificialPAMFactory implements FuegoArtificialFactory{
    @Override
    public FuegoArtificial crearFuegoArtificial() {
        return new FuegoArtificialPAM();
    }
}
