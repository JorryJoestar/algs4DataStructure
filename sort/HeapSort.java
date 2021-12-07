package sort;

public class HeapSort {
    public static <T extends Comparable<T>> void sort(T[] array) {

        T[] heap = (T[])new Comparable[array.length+1];
        for(int i=0;i < array.length;i++){
            heap[i+1] = array[i];
        }

        int N = array.length;
        for(int k=N/2;k>=1;k--){
            sink(heap,k,N);
        }

        while(N>1){
            exch(heap,1,N--);
            sink(heap,1,N);
        }

        for(int i=0;i<array.length;i++){
            array[i] = heap[i+1];
        }
    }

    private static <T extends Comparable<T>> void sink(T[] array, int k,int N){
        while(2*k<=N){
            int j = 2*k;
            if(j<N && less(array,j,j+1)) j++;
            if(!less(array,k,j)) break;
            exch(array,k,j);
            k = j;
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
