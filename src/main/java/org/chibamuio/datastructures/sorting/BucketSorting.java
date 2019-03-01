package org.chibamuio.datastructures.sorting;

public class BucketSorting {

    public static void sort(int[] array, int lowerRange, int upperRange){
        int i, j;
        int size = array.length;
        int range = upperRange - lowerRange;
        int[] count = new int[range];
        for(i=0; i < size; i++){
            count[array[i] - lowerRange]++;
            //System.out.printf("%d, %d, %d\n", array[i], array[i] - lowerRange, count[array[i] - lowerRange]);
        }
    }
    public static void main(String[] args) {
        int[] array = { 23, 24, 22, 21, 26, 25, 27, 28, 21, 21 };
        BucketSorting.sort(array, 20, 30);

        int M=12, N=21;
        int answer = M ^ 21;
        System.out.println(answer);
    }
}
