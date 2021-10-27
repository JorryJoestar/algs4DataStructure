package collections.implement;

import collections.api.Stack;
import java.util.Iterator;

public class ArrayStack<Item> extends Stack<Item>
{
    private int N;
    private Item[] items = (Item[])new Object[1];
    private void resize(int newSize)
    {
        Item[] newItems = (Item[])new Object[newSize];
        for(int i=0;i<items.length;i++) newItems[i] = items[i];
        items = newItems;
    }
    public void    push(Item item)
    {
        items[N++] = item;
        if(N==items.length) resize(N*2);
    }
    public Item    pop()
    {
        if(isEmpty()) return null;
        Item topItem = items[N-1];
        N--;
        if(N<items.length/4) resize(items.length/2);
        return topItem;
    }
    public Item    top()
    {
        if(isEmpty()) return null;
        return items[N-1];
    }
    public boolean isEmpty(){return N==0;}
    public int     size(){return N;}
    public Iterator<Item> iterator(){return new ArrayIterator();}
    private class ArrayIterator implements Iterator<Item>
    {
        private int currentIndex=N-1;
        public boolean hasNext(){return currentIndex>=0;}
        public Item next()
        {
            Item currentItem = items[currentIndex--];
            return currentItem;
        }
    }
}