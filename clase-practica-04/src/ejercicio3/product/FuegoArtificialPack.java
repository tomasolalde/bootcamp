package ejercicio3.product;

import java.util.ArrayList;

public class FuegoArtificialPack implements FuegoArtificial {

    private ArrayList<FuegoArtificial> individuales;
    private ArrayList<FuegoArtificialPack> packs;

    @Override
    public void explotar() {
        for(FuegoArtificial fa : individuales) {
            fa.explotar();
        }
        for (FuegoArtificialPack fap : packs) {
            fap.explotar();
        }
    }

    void agregarFuegoArtificialPUM() {
        individuales.add(new FuegoArtificialPUM());
    }

    void agregarFuegoArtificialPAM() {
        individuales.add(new FuegoArtificialPAM());
    }

    void agregarFuegoArtificialPUF() {
        individuales.add(new FuegoArtificialPUF());
    }

    void agregarPack(FuegoArtificialPack pack) {
        packs.add(pack);
    }

}
