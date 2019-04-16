package com.daydayup;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello world");
        int[] a = {1,2,3,4};
        perm(a, a.length);
        System.out.println("totally " + count + " permutations");
    }

    private static int count=0;
    private static void perm(int[] a, int length) {
        if(length==1){ //递归结束条件，只剩一个元素，无需再交换，输出a，即为一种排列方法
            print(a);
            ++count;
            return;
        }
        for(int i=0; i<length; ++i) {
            swap(a,i,length-1); //每次把a[0]换到a[length-1]
            perm(a, length-1);//递归进length-1
            swap(a,i,length-1);//把a[0]和a[length-1]交换回来
        }
    }

    private static void swap(int[] a, int idx1, int idx2){
        if(idx1 != idx2){
            int temp = a[idx2];
            a[idx2] = a[idx1];
            a[idx1] = temp;
        }
    }

    private static void print(int[] a) {
        for(int i=0; i<a.length-1; ++i){
            System.out.print(a[i]+",");
        }
        System.out.print(a[a.length-1]);
        System.out.println();

    }


}
