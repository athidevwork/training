package org.athi.solutions;

/**
 * <p>(C) 2003 Delphi Technology, inc. (dti)</p>
 * Date:   3/23/2019
 *
 * @author amuthukumarasamy
 */
/*
 *
 * Revision Date    Revised By  Description
 * ---------------------------------------------------
 *
 * ---------------------------------------------------
 */
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class FindMissingPositiveInteger {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int arr_size = A.length;
        int missing = findMissing(A, arr_size);
        /*System.out.println("The smallest positive missing number is "+
                            missing);*/
        return missing;
    }

    /* Utility function that puts all non-positive (0 and negative) numbers on left side of
       arr[] and return count of such numbers */
    static int separateNumbers (int arr[], int size) {
        int j = 0, i;
        for(i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // increment count of non-positive ntegers
                j++;
            }
        }

        return j;
    }

    /* Find the smallest positive missing number in an array that contains all positive integers */
    static int findMissingPositive(int arr[], int size) {
        int i;

        // Mark arr[i] as visited by making
        // arr[arr[i] - 1] negative. Note that
        // 1 is subtracted because index start
        // from 0 and positive numbers start from 1
        for(i = 0; i < size; i++) {
            int x = Math.abs(arr[i]);
            if(x - 1 < size && arr[x - 1] > 0)
                arr[x - 1] = -arr[x - 1];
        }

        // Return the first index value at which
        // is positive
        for(i = 0; i < size; i++)
            if (arr[i] > 0)
                return i+1;  // 1 is added becuase indexes
        // start from 0

        return size+1;
    }

    /* Find the smallest positive missing
       number in an array that contains
       both positive and negative integers */
    static int findMissing(int arr[], int size) {
        // First separate positive and negative numbers
        int shift = separateNumbers (arr, size);
        int arr2[] = new int[size-shift];
        int j=0;
        for(int i=shift;i<size;i++) {
            arr2[j] = arr[i];
            j++;
        }
        // Shift the array and call findMissingPositive for positive numbers
        return findMissingPositive(arr2, j);
    }
}

