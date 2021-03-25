package ejercicio2;

public class SocorristaMoto extends Vehiculo implements VehiculoSocorrista<Moto> {

    public SocorristaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        setPeso(300);
        setRuedas(2);
    }

    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo Moto -> Patente[" + vehiculo.getPatente() + "]");
    }
}
