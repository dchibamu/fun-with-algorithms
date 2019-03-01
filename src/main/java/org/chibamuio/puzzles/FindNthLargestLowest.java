package org.chibamuio.puzzles;

public class FindNthLargestLowest {

    public static int[] find3LargestNumbers(int[] data){
        int highest = Integer.MIN_VALUE, secondLargest=Integer.MIN_VALUE, thirdlargest =Integer.MIN_VALUE;
        int result[] = new int[3];
        if(data != null && data.length > 3){
            for(int i =0; i < data.length; i++){

                if(data[i] > highest){
                    thirdlargest = secondLargest;
                    secondLargest = highest;
                    highest = data[i];
                }else if(data[i] > secondLargest){
                    thirdlargest = secondLargest;
                    secondLargest = data[i];

                }else if(data[i] > thirdlargest){
                    thirdlargest = data[i];
                }
            }
            result[0] = thirdlargest;
            result[1] = secondLargest;
            result[2] = highest;
            return result;
        }
        return result;
    }

    public static int[] find3SmallestValues(int[] data){
        int lowest = Integer.MAX_VALUE, secondLowest = Integer.MAX_VALUE, thirdLowest = Integer.MAX_VALUE;
        int result[] = new int[3];
        if(data != null && data.length > 3){
            for(int i =0; i < data.length; i++){

                if(data[i] < lowest){
                    thirdLowest = secondLowest;
                    secondLowest = lowest;
                    lowest = data[i];
                }else if(data[i] < secondLowest){
                    thirdLowest = secondLowest;
                    secondLowest = data[i];

                }else if(data[i] < thirdLowest){
                    thirdLowest = data[i];
                }
            }
            result[2] = thirdLowest;
            result[1] = secondLowest;
            result[0] = lowest;
            return result;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {31, -7, -1, -101, -57, -58 ,-24, 10, -21, -41};
        int[] result = find3LargestNumbers(data);
        System.out.println(String.format("highest: %s secondLargest: %s thirdLargest: %s", result[0], result[1], result[2]));
        result = find3SmallestValues(data);
        System.out.println(String.format("Lowest: %s secondLowest: %s thirdLowest: %s", result[0], result[1], result[2]));
    }
}
