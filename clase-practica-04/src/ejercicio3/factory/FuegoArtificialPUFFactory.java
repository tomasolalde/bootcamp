package ejercicio3.factory;

import ejercicio3.product.FuegoArtificial;
import ejercicio3.product.FuegoArtificialPUF;

public class FuegoArtificialPUFFactory implements FuegoArtificialFactory{
    @Override
    public FuegoArtificial crearFuegoArtificial() {
        return new FuegoArtificialPUF();
    }
}
