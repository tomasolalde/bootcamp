package ejercicio3.product;

import java.util.ArrayList;

public class FuegoArtificialPack implements FuegoArtificial {

    private ArrayList<FuegoArtificial> fuegosArtificiales = new ArrayList<FuegoArtificial>();

    @Override
    public void explotar() {
        for(FuegoArtificial fa : fuegosArtificiales) {
            fa.explotar();
        }
    }

    public void agregarFuegoArtificialPUM() {
        fuegosArtificiales.add(new FuegoArtificialPUM());
    }

    public void agregarFuegoArtificialPAM() {
        fuegosArtificiales.add(new FuegoArtificialPAM());
    }

    public void agregarFuegoArtificialPUF() {
        fuegosArtificiales.add(new FuegoArtificialPUF());
    }

    public void agregarPack(FuegoArtificialPack pack) {
        fuegosArtificiales.add(pack);
    }

}
