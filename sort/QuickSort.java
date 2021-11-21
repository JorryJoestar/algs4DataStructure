package sort;

import java.util.Random;

public class QuickSort {
    public static <T extends Comparable> void sort(T[] array){
        shuffle(array);
        sort(array,0, array.length-1);
    }

    private static <T extends Comparable> void sort(T[] array,int begin,int end){
        if(begin>=end) return;
        int pos = partition(array,begin,end);
        sort(array,begin,pos-1);
        sort(array,pos+1,end);
    }

    private static <T extends Comparable> int partition(T[] array,int begin,int end){
        int i = begin;
        int j = end+1;
        while(true){
            while(less(array,++i,begin)) if(i==end) break;
            while(less(array,begin,--j)) if(j==begin) break;
            if(i>=j) break;
            exch(array,i,j);
        }
        exch(array,begin,j);
        return j;
    }

    private static <T extends Comparable> void shuffle(T[] array){
        for(int i=1;i<array.length;i++){
            Random rd = new Random();
            int k = rd.nextInt(array.length-i);
            exch(array,k, array.length-i);
        }
    }

    private static <T extends Comparable<T>> boolean less(T[]array,int a,int b) {
        return array[a].compareTo(array[b]) < 0;
    }

    private static <T extends Comparable<T>> void exch(T[] array,int a,int b) {
        T temp   = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
