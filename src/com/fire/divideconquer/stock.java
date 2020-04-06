package com.fire.divideconquer;

/**
 * buy only one time to get the best profit,
 * using divide and conque way. 
 * 
 * Dynamic programming should also works.
 */
public class stock {


    // Input: 19 32 9 78 1 67 54 43, 
    // best buy should be at 9 and sell it at 78
    public static void main(String[] args) {
        int[] input = new int[] {19, 32, 9, 78, 100, 1, 54, 43};
        System.out.println(search(input, 0, input.length - 1));

    }

    private static int search(int[] arrays, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int middle = (start + end) /2;
        int left = search(arrays, start, middle);
        int right = search(arrays, middle + 1, end);
        int cross = crossMiddle(arrays, start, middle, end);
        int max = cross;
        if (max < left) max = left;
        if (max < right) max = right;
        return max;
        
    } 

    private static int crossMiddle(int[] arrays, int start, int middle, int end) {
        System.out.println(String.format("Cross %d %d %d", start, middle, end));
        int max = 0;
        int temp = 0;
        int index = middle - 1;
        while(index >= start) {
            int delta = arrays[index+1] - arrays[index];
            temp += delta;
            if (max < temp) max = temp;
            index--;
        }
        index = middle + 1;
        temp = max;
        while(index <= end) {
            int delta = arrays[index] - arrays[index - 1];
            temp += delta;
            if (max < temp) max = temp;
            index++;
        }
        return max;
    }



}

