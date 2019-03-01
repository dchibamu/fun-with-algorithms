package org.chibamuio.datastructures.sorting;

import java.util.Arrays;

public class QuickSorting {

    public static void quickSort(int arr[], int low, int high){

        if(low > high)
            return;
        int i = low;
        int j = high;
        int pivotIdx = low + (high - low)/2;
        int pivot = arr[pivotIdx];
        while(i <= j){

            while(arr[i] < pivot)
                i++;

            while(arr[j] > pivot)
                j--;

            if(i <= j){
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if(low <j){
            quickSort(arr, low, j);
        }

        if(high > i){
            quickSort(arr, i, high);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {

        //int[] arr = { 20, 35, -15, 7, 55, 1, -22};
        int[] arr = {12, 5, 8, -4, 0, 1, 0, 15, 3, 11, -1, 1, -1};
        quickSort(arr, 0, arr.length -1);
        Arrays.stream(arr).forEach(System.out::println);
    }


}
