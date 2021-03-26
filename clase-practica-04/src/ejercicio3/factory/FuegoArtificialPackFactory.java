package ejercicio3.factory;

import ejercicio3.product.FuegoArtificial;
import ejercicio3.product.FuegoArtificialPack;

import java.util.ArrayList;

public interface FuegoArtificialPackFactory {
    FuegoArtificialPack crearPack();
}
