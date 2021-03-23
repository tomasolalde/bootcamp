package bootcamp.ejercicio2;

public class Triangulo extends FiguraGeometrica {
    public double altura;
    public double base;

    public Triangulo(double altura, double base) {
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double area() {
        return (base * altura) / 2;
    }
}
