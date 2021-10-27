/**
 *  pq[0] is idle
 */

package assist;

import java.util.Iterator;

public class MaxPriorityQueue<Key extends Comparable<Key>>
{
    private Key[] pq;
    private int N;
    public MaxPriorityQueue(){pq = (Key[])new Comparable[2];}
    public MaxPriorityQueue(int max){pq = (Key[])new Comparable[max+1];}
    public MaxPriorityQueue(Key[] a)
    {
        N = a.length-1;
        pq = (Key[])new Comparable[N+1];
        for(int i=1;i<=N;i++) pq[i] = a[i];
        int k = 1;
        while(k<=N) k = 2*k+1;
        for(int i=k;i>=1;i--) sink(i);
    }
    public void insert(Key v)
    {
        N++;
        pq[N] = v;
        swim(N);
        if(N+1==pq.length) resize(pq.length*2);
    }
    public Key max(){if(isEmpty())return null;return pq[1];}
    public Key delMax()
    {
        if(isEmpty()) return null;
        Key max = pq[1];
        swap(1,N);
        N--;
        sink(1);
        return max;
    }
    public boolean isEmpty(){return N==0;}
    public int size(){return N;}
    public Key[] toArray(){return pq;}
    private void swap(int i,int j)
    {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    private boolean less(int i,int j){return pq[i].compareTo(pq[j])<0;}
    private void swim(int k)
    {
        while(k>1 && less(k/2,k))
        {
            swap(k/2,k);
            k = k/2;
        }
    }
    private void sink(int k)
    {
        while(2*k<=N)
        {
            int j = 2*k;
            if(j<N && less(j,j+1)) j++;
            if(!less(k,j)) break;
            swap(k,j);
            k = j;
        }
    }
    private void resize(int newSize)
    {
        Key[] newPq = (Key[])new Comparable[newSize];
        for(int i=1;i<=N;i++) newPq[i] = pq[i];
        pq = newPq;
    }
}
