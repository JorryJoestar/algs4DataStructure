package collections.implement;

import collections.api.Bag;
import java.util.Iterator;

public class ArrayBag<Item> extends Bag<Item>
{
    private int    N;
    private Item[] items = (Item[])new Object[1];

    private void   resize (int size)
    {
        Item[] newItems = (Item[])new Object[size];
        for(int i=0;i<N;i++){newItems[i]=items[i];}
        items = newItems;
    }
    public boolean isEmpty(){return N==0;}
    public int     size()   {return N;}
    public void    add(Item item)
    {
        items[N++] = item;
        if(items.length==N) resize(N*2);
    }
    public Iterator<Item> iterator(){return new ArrayIterator();}
    private class ArrayIterator implements Iterator<Item>
    {
        private int currentIndex = 0;
        public boolean hasNext(){return currentIndex<N;}
        public Item next()
        {
            int itemIndex = currentIndex;
            currentIndex++;
            return items[itemIndex];
        }
    }

}
