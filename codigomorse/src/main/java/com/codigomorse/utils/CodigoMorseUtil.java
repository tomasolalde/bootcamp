package com.codigomorse.utils;

import java.util.HashMap;

public class CodigoMorseUtil {

    public static String traducir(String codigo) {
        HashMap<String, Character> diccionario = crearDiccionario();
        StringBuilder respuesta = new StringBuilder();
        String[] palabras = codigo.split(" {3}");

        for (String palabra : palabras) {
            StringBuilder palabraTraducida = new StringBuilder();
            String[] caracteres = palabra.split(" ");

            for (String caracterMorse : caracteres) {
                Character a = diccionario.get(caracterMorse);
                palabraTraducida.append(a);
            }
            respuesta.append(palabraTraducida).append(" ");
        }
        return respuesta.toString();
    }

    public static HashMap<String, Character> crearDiccionario() {
        HashMap<String, Character> dic = new HashMap<String, Character>();
        dic.put(".-", 'A');
        dic.put("–.–.", 'B');
        dic.put("––––", 'C');
        dic.put("–..", 'D');
        dic.put(".", 'E');
        dic.put("..-.", 'F');
        dic.put("--.", 'G');
        dic.put("....", 'H');
        dic.put("..", 'I');
        dic.put(".---", 'J');
        dic.put("-.-", 'K');
        dic.put(".-..", 'L');
        dic.put("--", 'M');
        dic.put("-.", 'N');
        dic.put("--.--", 'Ñ');
        dic.put("---", 'O');
        dic.put(".--.", 'P');
        dic.put("--.-", 'Q');
        dic.put(".-.", 'R');
        dic.put("...", 'S');
        dic.put("-", 'T');
        dic.put("..-", 'U');
        dic.put("...-", 'V');
        dic.put(".--", 'W');
        dic.put("-..-", 'X');
        dic.put("-.--", 'Y');
        dic.put("--..", 'Z');
        dic.put(".----", '1');
        dic.put("..---", '2');
        dic.put("...--", '3');
        dic.put("....-", '4');
        dic.put(".....", '5');
        dic.put("-....", '6');
        dic.put("--...", '7');
        dic.put("---..", '8');
        dic.put("----.", '9');
        dic.put("-----", '0');
        return dic;
    }

}
