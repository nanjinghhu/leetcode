package com.alhata.algo.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2,1,3,5,4,2,6,3,44,23};
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr, int n) {
        if(arr == null || arr.length <= 1 || n < 1) {
            return;
        }

        for(int i = n/2 - 1; i>=0; i--) {
            heapfy(arr, n, i);
        }

        for(int i=n-1; i>0;i--) {
            SortCommonUtil.swap(arr, 0, i);
            heapfy(arr, i, 0);
        }
    }

    private static void heapfy(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if( left < n && arr[largest] < arr[left] ) {
            largest = left;
        }

        if(right < n && arr[largest] < arr[right]) {
            largest = right;
        }

        if (largest != i) {
            SortCommonUtil.swap(arr, largest, i);
            heapfy(arr, n, largest);
        }
    }
}
