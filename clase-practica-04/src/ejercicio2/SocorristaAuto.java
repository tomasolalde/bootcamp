package ejercicio2;

public class SocorristaAuto extends Vehiculo implements VehiculoSocorrista<Auto> {

    public SocorristaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        setPeso(1000);
        setRuedas(4);
    }

    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo Auto -> Patente [" + auto.getPatente() + "]");
    }
}
