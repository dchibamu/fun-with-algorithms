package org.chibamuio.datastructures.sorting;

import java.util.Arrays;

public class SelectionSorting {

    static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = i;

            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(i != min){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }

        }
    }

    void swap(int arr[], int i, int j){

    }
    public static void main(String[] args) {
        int [] arr = {2, 5, 7, 27, 26, 3, 9};
        selectionSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
