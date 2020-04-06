package com.fire.sort;

import java.util.Arrays;

public class mergesort {


    private static void merge(int[] arrays, int start, int middle, int end) {
        int[] arrayL = new int[middle - start + 1];
        int[] arrayR = new int[end - middle];
        System.arraycopy(arrays, start, arrayL, 0, arrayL.length);
        System.arraycopy(arrays, middle + 1, arrayR, 0, arrayR.length);
        System.out.println("Left: " + Arrays.toString(arrayL));
        System.out.println("Right: " + Arrays.toString(arrayR));
        int li = 0, lr = 0;
        int i = start;
        for(; i < end ; i++){
            if (li < arrayL.length && lr < arrayR.length) {
                if (arrayL[li] < arrayR[lr]) {
                    arrays[i] = arrayL[li];
                    li++;
                } else {
                    arrays[i] = arrayR[lr];
                    lr++;
                }
            } else {
                break;
            }   
        }
        if(li == arrayL.length) System.arraycopy(arrayR, lr, arrays, i, arrayR.length - lr);
        if(lr == arrayR.length) System.arraycopy(arrayL, li, arrays, i, arrayL.length - li);

        System.out.println("Merged: " + Arrays.toString(arrays));
    }

    public static void mergeSort(int[] arrays, int start, int end) {
        System.out.println(start + ": " + end);
        if(start < end) {
            mergeSort(arrays, start, (start + end) /2);
            mergeSort(arrays, (start + end) /2 + 1, end);
            merge(arrays, start, (start + end) /2 , end);
        }
    }
    public static void main(String[] args) {

        int[] toSort1 = new int[] {99,3,2,1,7,8,9,23,22,21};
        mergeSort(toSort1, 0, toSort1.length - 1);
        System.out.println(Arrays.toString(toSort1));
    }

}