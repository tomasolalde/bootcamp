package ejercicio2;

public abstract class Vehiculo {

    double velocidad = 0;
    double aceleracion = 0;
    double anguloDeGiro = 0;
    String patente = "";
    double peso = 0;
    int ruedas = 0;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        setVelocidad(velocidad);
        setAceleracion(aceleracion);
        setAnguloDeGiro(anguloDeGiro);
        setPatente(patente);
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public double velocidadMaxima() {
        return velocidad * ((0.5*aceleracion) / (anguloDeGiro * (peso - ruedas * 100)));
    }
}
