package org.chibamuio.datastructures.sorting;

public class MergeSorting {
    int[] data;
    int[] tempArray;
    void prepareSort(int[] arr){
        this.data = arr;
        this.tempArray = new int[arr.length];
        mergeSort(0, data.length - 1);
    }
    public static void mergeSort(int lowerIndex, int higherIndex){
        if(lowerIndex < higherIndex){
            int middleIndex = lowerIndex + (higherIndex - lowerIndex)/2;
            mergeSort(lowerIndex, middleIndex);
            mergeSort(middleIndex+1, higherIndex);
            merge(lowerIndex, middleIndex, higherIndex);
        }
    }

    private static void merge(int lowerIndex, int middleIndex, int higherIndex){

    }
    public static void main(String[] args) {

    }
}
