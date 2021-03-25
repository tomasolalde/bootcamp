package ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;

public class Carrera {
    public double distancia;
    public double premioEnDolares;
    public String nombre;
    public int intcantidadDeVehiculosPermitidos;
    public SocorristaAuto socorristaAuto;
    public SocorristaMoto socorristaMoto;
    ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    public Carrera(double distancia, double premioEnDolares, String nombre, int intcantidadDeVehiculosPermitidos) {
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.intcantidadDeVehiculosPermitidos = intcantidadDeVehiculosPermitidos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < intcantidadDeVehiculosPermitidos) {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < intcantidadDeVehiculosPermitidos) {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void darDeAltaSocoristaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        this.socorristaAuto = new SocorristaAuto(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public void darDeAltaSocorristaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        this.socorristaMoto = new SocorristaMoto(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        eliminarVehiculoPorPatente(vehiculo.getPatente());
    }

    public void eliminarVehiculoPorPatente(String patente) {
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public void socorrerAuto(String patente) {
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equals(patente) && v instanceof Auto) {
                this.socorristaAuto.socorrer((Auto) v);
            }
        }
    }

    public void socorrerMoto(String patente) {
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equals(patente) && v instanceof Moto) {
                this.socorristaMoto.socorrer((Moto) v);
            }
        }
    }

    public String getGanador() {
        Vehiculo vehiculoGanador = null;
        for (Vehiculo v : vehiculos) {
            if (vehiculoGanador != null) {
                if (v.velocidadMaxima() > vehiculoGanador.velocidadMaxima()) {
                    vehiculoGanador = v;
                }
            } else {
                vehiculoGanador = v;
            }
        }
        if (vehiculoGanador != null) return vehiculoGanador.toString();
        return null;
    }

    @Override
    public String toString() {
        return "Carrera: " +
                "Distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", intcantidadDeVehiculosPermitidos=" + intcantidadDeVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                '}';
    }

    public void mostrarParticipantes() {
        System.out.println(Arrays.toString(vehiculos.toArray()));
    }
}
