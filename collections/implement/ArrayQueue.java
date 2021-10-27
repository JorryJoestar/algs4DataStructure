package collections.implement;

import collections.api.Queue;

import java.util.Iterator;

public class ArrayQueue<Item> extends Queue<Item> {
    private int N;
    private int head;
    private Item[] items = (Item[])new Object[1];
    private void   resize(int newSize)
    {
        Item[] newItems = (Item[])new Object[newSize];
        for(int i=0;i<items.length;i++) newItems[i] = items[i];
        items = newItems;
        head = 0;
    }
    public void    enQueue(Item item)
    {
        items[(head+N)%items.length] = item;
        N++;
        if(N == items.length) resize(N*2);
    }
    public Item    deQueue()
    {
        if(isEmpty()) return null;
        Item headItem = items[head];
        head = (head+1)% items.length;
        N--;
        if(N < items.length/4) resize(items.length/2);
        return headItem;
    }
    public boolean isEmpty(){return N==0;}
    public int     size(){return N;}
    public Iterator<Item> iterator(){return new ArrayIterator();}
    private class ArrayIterator implements Iterator<Item>
    {
        private int currentIndex = head;
        private int remainedN = N;
        public boolean hasNext()
        {
            boolean hasNext = remainedN>0;
            remainedN--;
            return hasNext;
        }
        public Item next()
        {
            Item currentItem = items[currentIndex];
            currentIndex = (currentIndex+1)%items.length;
            return currentItem;
        }
    }
}
