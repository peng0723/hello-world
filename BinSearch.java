package com.daydayup;

public class BinSearch {
    //a为从小到大排序的有序数组，在a中查找第一个大于等于x的值，返回该值的index
    public static int bsearch(int[] a, int x) {
        int low = 0;
        int high = a.length-1;
        while (low<=high){
            int mid = low + ((high-low)>>1); //注意+比>>优先级高，可以写成low+(high-low)/2
            if(a[mid]<x){
                low = mid+1;
            }
            else { //a[mid]>=x
                if(mid==0||a[mid-1]<x){
                    return mid;
                }
                else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        //int i = 2+((2-2)>>1);
        int[] a = {1,3,5,5,5,6,7};
        int index = bsearch(a, 5);
        System.out.println("the first \"greater or equal\" index is " + index);
    }
}
