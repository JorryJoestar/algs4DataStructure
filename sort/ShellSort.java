package sort;

public class ShellSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        int h = 1;
        while(h<array.length/3) h = 3*h+1;
        while(h>=1) {
            for(int i = h;i<array.length;i++) {
                for(int j = i;j >= h && less(array,j,j-h);j -= h)
                    exch(array,j,j-h);
            }
            h /= 3;
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
