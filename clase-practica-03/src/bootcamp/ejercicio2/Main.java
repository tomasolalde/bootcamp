package bootcamp.ejercicio2;

public class Main {

    public static void main(String[] args) {
        FiguraGeometrica[] arr = new FiguraGeometrica[3];
        Circulo circulo = new Circulo(20);
        Rectangulo rectangulo = new Rectangulo(10, 30);
        Triangulo triangulo = new Triangulo(21, 56);

        arr[0] = circulo;
        arr[1] = rectangulo;
        arr[2] = triangulo;

        double areaPromedio = FigurasGeometricasUtils.areaPromedio(arr);
        System.out.println("Area promedio: " + areaPromedio);
    }

}
