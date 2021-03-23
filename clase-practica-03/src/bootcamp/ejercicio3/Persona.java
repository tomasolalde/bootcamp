package bootcamp.ejercicio3;

public class Persona implements Precedable<Persona> {

    public String nombre;
    public String DNI;

    public Persona(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }

    @Override
    public int precedeA(Persona persona) {
        int result = 1;
        if (Integer.parseInt(persona.DNI) < Integer.parseInt(this.DNI)) result = -1;
        return result;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                '}';
    }
}
