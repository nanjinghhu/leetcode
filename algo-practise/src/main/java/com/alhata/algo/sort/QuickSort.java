package com.alhata.algo.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {25,14,3,66,35,32,62,44};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition-1);
            quickSort(arr, partition+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
       int pivot = arr[high];
       int i = low;
       for(int j=low; j<high;j++) {
           if(arr[j] < pivot) {
               SortCommonUtil.swap(arr, i, j);
               i++;
           }
       }
       SortCommonUtil.swap(arr, i, high);
       return i;
    }
}
