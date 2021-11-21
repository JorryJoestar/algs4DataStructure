package sort;

import java.util.Random;

public class QuickSortThreeWay {
    public static <T extends Comparable> void sort(T[] array){
        //shuffle(array);
        sort(array,0, array.length-1);
    }

    private static <T extends Comparable> void sort(T[] array,int begin,int end){
        if(begin>=end) return;
        int i = begin+1;
        int lt = begin;
        int gt = end;
        T v = array[begin];
        while(i<=gt) {
            int cmp = array[i].compareTo(v);
            if      (cmp < 0) exch(array, lt++, i++);
            else if (cmp > 0) exch(array, gt--, i);
            else              i++;
        }
        sort(array,begin,lt-1);
        sort(array,gt+1,end);
    }

    private static <T extends Comparable> void shuffle(T[] array){
        for(int i=1;i<array.length;i++){
            Random rd = new Random();
            int k = rd.nextInt(array.length-i);
            exch(array,k, array.length-i);
        }
    }

    private static <T extends Comparable<T>> void exch(T[] array,int a,int b) {
        T temp   = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
