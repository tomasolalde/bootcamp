package bootcamp.ejercicio2;

public class Rectangulo extends FiguraGeometrica {
    public double altura;
    public double base;

    public Rectangulo(double altura, double base) {
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double area() {
        return altura * base;
    }
}
