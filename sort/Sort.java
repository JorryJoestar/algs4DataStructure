package sort;

public class Sort {
    public static <T extends Comparable<T>> T[] selection(T[] array)
    {
        int minIndex;
        for(int i=0;i<array.length-1;i++)
        {
            minIndex = i;
            for(int j=i+1;j<array.length;j++)
                if(array[j].compareTo(array[minIndex]) < 0){minIndex = j;}
            T temp          = array[minIndex];
            array[minIndex] = array[i];
            array[i]        = temp;
        }
        return array;
    }

    public static <T extends Comparable<T>> T[] insertion(T[] array)
    {
        for(int i=1;i<array.length;i++)
        {
            for(int j=i;j>=1;j--)
            {
                if (array[j].compareTo(array[j - 1]) >= 0) break;
                T temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
        return array;
    }

    public static <T extends Comparable<T>> T[] shell(T[] array)
    {
        //TODO shellsort
        return array;
    }

    public static <T extends Comparable<T>> T[] merge(T[] array)
    {
        //TODO mergesort
        return array;
    }

    public static <T extends Comparable<T>> T[] quick(T[] array)
    {
        //TODO quicksort
        return array;
    }

    public static <T extends Comparable<T>> T[] heap(T[] array)
    {
        //TODO heapsort
        return array;
    }

    public static <T extends Comparable<T>> T[] invert(T[] array)
    {
        for(int i=0;i<array.length/2;i++)
        {
            T temp                = array[i];
            array[i]              = array[array.length-i-1];
            array[array.length-i-1] = temp;
        }
        return array;
    }



}
