package sort;

public class SelectionSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        int minIndex;
        for(int i = 0;i<array.length - 1;i++) {
            minIndex = i;
            for(int j = i + 1;j<array.length;j++)
                if(less(array,j,minIndex)){minIndex = j;}
            exch(array,minIndex,i);
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
