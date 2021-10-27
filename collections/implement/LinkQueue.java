package collections.implement;

import collections.api.Queue;
import java.util.Iterator;

public class LinkQueue<Item> extends Queue<Item>
{
    private int N;
    private Node head;
    private Node tail;
    private class Node
    {
        Item value;
        Node next;
        public Node(Item value){this.value = value;}
    }
    public void    enQueue(Item item)
    {
        if(isEmpty()){head = new Node(item);tail = head; N++;}
        else         {Node newTail = new Node(item);tail.next = newTail;tail = newTail;N++;}
    }
    public Item    deQueue()
    {
        if(isEmpty()) return null;
        Item currentItem = head.value;
        head = head.next;
        if(size()==1) tail = null;
        N--;
        return currentItem;
    }
    public boolean isEmpty(){return N==0;}
    public int     size(){return N;}
    public Iterator<Item> iterator(){return new LinkIterator();}
    private class LinkIterator implements Iterator<Item>
    {
        private Node currentNode = head;
        public boolean hasNext(){return currentNode != null;}
        public Item next()
        {
            Item currentItem = currentNode.value;
            currentNode = currentNode.next;
            return currentItem;
        }
    }

}
