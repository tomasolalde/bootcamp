package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StringUtil {
    /**
     * Retorna una cadena compuesta por n caractedes c
     * @param c caracteres
     * @param n longitud
     * @return
     */
    public static String replicate(char c, int n) {
        String str = "";
        for (int i = 0; i < n; i++)
            str += c;
        return str;
    }

    /***
     * Retorna una cadena de longitud n, compuesta por s
     * y procedida de tantos caracteres c como sea necesario
     * para completar la longitud pasada por parametro
     * Ej: ("5",3,'0') ==> "005"
     * @param s cadena
     * @param n longitud
     * @param c caracter
     * @return
     */
    public static String lpad(String s, int n, char c) {
        if (s.length() < n) {
            int digitsToAdd = n - s.length();
            s = replicate(c, digitsToAdd) + s;
        }
        return s;
    }

    /***
     * Transforma un array de int a un array de
     * Strings
     * @param arr
     * @return
     */
    public static String[] toStringArray(Object[] arr) {
        String[] arrayString = new String[arr.length];
        for (int i = 0; i < arr.length; i++)
            arrayString[i] = arr[i].toString();
        return arrayString;
    }

    /***
     * Transforma un array de enteros a un array de
     * int
     * @param arr
     * @return
     */
    public static int[] toIntArray(String arr[]) {
        int[] arrayInt = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            arrayInt[i] = Integer.parseInt(arr[i]);
        return arrayInt;
    }

    /***
     * Retorna la longitud del mayor elemento dentro del array
     * @param arr
     * @return
     */
    public static String maxLength(String arr[]) {
        String max = "";
        for (String value : arr) {
            if (value.length() > max.length()) max = value;
        }
        return max;
    }

    /***
     * Normaliza todas las cadenas dentro del array para que
     * todas tengan la misma cantidad de caracteres, completando
     * con el caracter c
     * @param arr
     * @param c
     * @return
     */
    public static String[] lNormalize(String arr[], char c) {
        String[] newArray = new String[arr.length];
        String max = maxLength(arr);
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = lpad(arr[i], max.length(), c);
        }
        return newArray;
    }

    /**
     * Retorna todos los caractedes distintos que existan dentro
     * de todos los numeros que contiene el arr
     *
     * @param arr array de strings
     * @return
     */
    public static ArrayList<Character> differentCharacters(String[] arr) {
        ArrayList<Character> diferentChars = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String num = arr[i];
            for (int j = 0; j < num.length(); j++) {
                char c = num.charAt(j);
                if (!diferentChars.contains(c)) diferentChars.add(c);
            }
        }
        Collections.sort(diferentChars);
        return diferentChars;
    }

    /***
     * Crea una HashMap ordenada en donde cada key es cada uno de los
     * distintos caracteres que contiene el arr, y el value es un ArrayList vacio
     * donde se van a  almacenar los distintos valores del vector
     * @param arr array de strings
     * @return
     */
    public static HashMap<String, ArrayList<String>> createStructure(String[] arr) {
        ArrayList<Character> differentChars = differentCharacters(arr);
        HashMap<String, ArrayList<String>> structure = new HashMap<>();
        for (Character c : differentChars) {
            structure.put(c.toString(), new ArrayList<String>());
        }
        return structure;
    }

    /***
     * Elimina los elementos dentro de cada arrayList que contenga la estructura
     * @param structure
     */
    public static void clearStructure(HashMap<String, ArrayList<String>> structure) {
        for (Map.Entry<String, ArrayList<String>> entry : structure.entrySet()) {
            entry.getValue().clear();
        }
    }

    /***
     * Rearma un array a partir de la estructura de hashmap que reciba por parametro
     * @param structure estructura del algoritmo en cada ordenamiento
     * @return
     */
    public static String[] rearmArray(HashMap<String, ArrayList<String>> structure) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Map.Entry<String, ArrayList<String>> entry : structure.entrySet()) {
            ArrayList<String> array = entry.getValue();
            arrayList.addAll(array);
        }
        String[] strArray = new String[arrayList.size()];
        strArray = arrayList.toArray(strArray);
        return strArray;
    }

    public static String rpad(String s, char c, int n) {
        if (s.length() < n) {
            int digitsToAdd = n - s.length();
            s = s + replicate(c, digitsToAdd);
        }
        return s;
    }

    public static String ltrim(String s) {
        return s.replaceAll("^\\s+", "");
    }

    public static String rtrim(String s) {
        return s.replaceAll("\\s+$", "");
    }

    public static String trim(String s) {
        String rtrim = rtrim(s);
        return ltrim(rtrim);
    }

    public static int indexOfN(String s, char c, int n) {
        int count = 0;
        int i = 0;
        while (i < s.length()) {
            if(s.charAt(i) == c) count++;
            if(n == count) return i;
            i++;
        }
        return -1;
    }

}