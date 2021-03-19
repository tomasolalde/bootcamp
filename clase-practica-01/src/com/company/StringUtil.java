package com.company;

import java.util.*;

public class StringUtil {
    /**
     * Retorna una cadena compuesta por n caractedes c
     *
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

    /*
    Retorna un String[] conteniendo los elementos de arr
    representados como cadenas de caracteres
     */
    public static String[] toStringArray(int arr[]) {
        String[] arrayString = new String[arr.length];
        for (int i = 0; i < arr.length; i++)
            arrayString[i] = Integer.toString(arr[i]);
        return arrayString;
    }

    /*
    Retorna un String[] conteniendo los elementos de arr
    representados como cadenas de caracteres
     */
    public static int[] toIntArray(String arr[]) {
        int[] arrayInt = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            arrayInt[i] = Integer.parseInt(arr[i]);
        return arrayInt;
    }

    /*
    Retorna la longitud del elemento con mayor cantidad
    de caracteres del array arr
     */
    public static int maxLength(String arr[]) {
        int max = 0;
        for (String value : arr) {
            if (Integer.parseInt(value) > max) max = Integer.parseInt(value);
        }
        return Integer.toString(max).length();
    }

    /*
    Completa los elemento del arr agregando caracteres c
    a la izquierda, dejando a todos con la longitud del mayor
     */
    public static String[] lNormalize(String arr[], char c) {
        String[] newArray = new String[arr.length];
        int maxLength = maxLength(arr);
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = lpad(arr[i], maxLength, c);
        }
        return newArray;
    }

    /**
     * Retorna todos los caractedes distintos que existan dentro
     * de todos los numeros que contiene el arr
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
     * Rearma un array a partir de la estructura de hashmap que reciba por parametro
     * @param structure estructura del algoritmo en cada ordenamiento
     * @return
     */
    public static String[] rearmArray(HashMap<String, ArrayList<String>> structure) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Map.Entry<String, ArrayList<String>> entry : structure.entrySet()) {
            ArrayList<String> array = entry.getValue();
            for (int i = 0; i < array.size(); i++) {
                arrayList.add(array.get(i));
            }
        }

        String[] strArray = new String[arrayList.size()];
        strArray = arrayList.toArray(strArray);
        return strArray;
    }
}