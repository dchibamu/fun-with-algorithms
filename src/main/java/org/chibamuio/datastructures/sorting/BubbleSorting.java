package org.chibamuio.datastructures.sorting;

import java.util.Arrays;

public class BubbleSorting {

    static void bubbleSort(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n; i++){

            for(int j = 1; j < n; j++){

                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int [] arr = {2, 5, 7, 27, 26, 3, 9};
        bubbleSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
