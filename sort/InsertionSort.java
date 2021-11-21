package sort;

public class InsertionSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        for(int i = 1;i < array.length;i++) {
            for(int j=i;j>=1;j--) {
                if (less(array,j-1,j)) break;
                exch(array,j-1,j);
            }
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
