package collections.implement;

import collections.api.Bag;
import java.util.Iterator;

public class LinkBag<Item> extends Bag<Item>
{
    private int    N;
    private Node first;
    private class Node
    {
        Item value;
        Node next;
    }

    public boolean isEmpty(){return N==0;}
    public int     size()   {return N;}
    public void    add(Item item)
    {
        N++;
        Node currentNode = new Node();
        currentNode.value = item;
        currentNode.next = first;
        first = currentNode;
    }
    public Iterator<Item> iterator(){return new LinkIterator();}
    private class LinkIterator implements Iterator<Item>
    {
        private Node currentNode=first;
        public boolean hasNext(){return currentNode!=null;}
        public Item next()
        {
            Item currentItem = currentNode.value;
            currentNode = currentNode.next;
            return currentItem;
        }
    }

}
