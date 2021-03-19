package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RadixSortEjerc {

    public static void radixSort(int[] arr) {
        StringUtil stringUtil = new StringUtil();
        String[] normalizedArray = stringUtil.lNormalize(stringUtil.toStringArray(arr), '0');

        int maxNumberLength = normalizedArray[0].length();

        for (int j = maxNumberLength - 1; j >= 0; j--) {
            HashMap<String, ArrayList<String>> structure = stringUtil.createStructure(normalizedArray);
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

        int arr[] = {1623, 898, 13, 906, 235, 1231,23, 1532, 32, 2511, 8, 7, 0};

        radixSort(arr);
    }

}