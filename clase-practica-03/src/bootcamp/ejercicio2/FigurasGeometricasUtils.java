package bootcamp.ejercicio2;

public class FigurasGeometricasUtils {

    public static double areaPromedio(FiguraGeometrica[] arr) {
        double areaPromedio = 0;
        for (FiguraGeometrica figura : arr) {
            areaPromedio += figura.area();
        }
        return areaPromedio;
    }

}
