package sort;

public class MergeSortBottomUp{
    public static <T extends Comparable> void sort(T[] array){
        T[] aux = (T[])new Comparable[array.length];
        sort(array,aux,0, array.length-1);
    }

    private static <T extends Comparable> void sort(T[] array,T[] aux,int begin,int end){
        if(begin==end)
            return;
        int mid = (begin + end)/2;
        sort(array,aux,begin,mid);
        sort(array,aux,mid+1,end);
        merge(array,aux,begin,mid,end);
    }

    private static <T extends Comparable> void merge(T[] array,T[] aux,int begin,int mid,int end){
        dump(aux,array,begin,end);
        int i = begin;
        int j = mid+1;
        for(int k = begin;k <=end;k++){
            if(i>mid)              array[k] = aux[j++];
            else if(j>end)         array[k] = aux[i++];
            else if(less(aux,j,i)) array[k] = aux[j++];
            else                   array[k] = aux[i++];
        }
    }

    private static <T extends Comparable<T>> boolean less(T[]array,int a,int b) {
        return array[a].compareTo(array[b]) < 0;
    }

    private static <T extends Comparable<T>> void dump(T[] target,T[]source,int begin,int end){
        for(int i = begin;i <= end;i++)
            target[i] = source[i];
    }
}
