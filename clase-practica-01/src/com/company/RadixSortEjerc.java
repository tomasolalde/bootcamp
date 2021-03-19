package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RadixSortEjerc {

    public static void radixSort(Object[] arr) {
        StringUtil stringUtil = new StringUtil();
        char x = '.';
        if(arr instanceof Integer[]) x = '0';
        if(arr instanceof String[]) x = 'a';
        String[] normalizedArray = stringUtil.lNormalize(stringUtil.toStringArray(arr), x);
        HashMap<String, ArrayList<String>> structure = stringUtil.createStructure(normalizedArray);
        int maxNumberLength = normalizedArray[0].length();

        for (int j = maxNumberLength - 1; j >= 0; j--) {
            stringUtil.clearStructure(structure);
            for (int i = 0; i < normalizedArray.length; i++) {
                Character c = normalizedArray[i].charAt(j);
                ArrayList<String> arrayList = structure.get(Character.toString(c));
                arrayList.add(normalizedArray[i]);
            }
            normalizedArray = stringUtil.rearmArray(structure);
        }

        System.out.println(Arrays.toString(normalizedArray));
    }

    public static void main(String[] args) {
        //Integer arr[] = {1623, 5, 898, 13, 906, 235, 1231, 1, 2, 3, 4, 23, 1532, 32, 2511, 8, 7, 0};
        String[] arr = {"asd", "ddd", "102931''¡3", "a", "das", "okp--", "aaa", "qwerty", "jeje", "jojo"};

        radixSort(arr);
    }

}