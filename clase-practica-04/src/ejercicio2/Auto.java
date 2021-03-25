package ejercicio2;

public class Auto extends Vehiculo {

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        setPeso(1000);
        setRuedas(4);
    }

    @Override
    public String toString() {
        return "Auto {" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}
