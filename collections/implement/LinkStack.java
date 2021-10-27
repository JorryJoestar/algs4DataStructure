package collections.implement;

import collections.api.Stack;
import java.util.Iterator;

public class LinkStack<Item> extends Stack<Item>
{
    private int N;
    private Node top;
    private class Node
    {
        Item value;
        Node next;
        public Node(Item value,Node next){this.value = value; this.next = next;}
    }
    public void    push(Item item){top = new Node(item,top); N++;}
    public Item    pop()
    {
        if(isEmpty()) return null;
        Item topValue = top.value;
        top = top.next;
        N--;
        return topValue;
    }
    public Item    top(){if(isEmpty()) return null; return top.value;}
    public boolean isEmpty(){return N==0;}
    public int     size(){return N;}
    public Iterator<Item> iterator(){return new LinkIterator();}
    private class LinkIterator implements Iterator<Item>
    {
        private Node currentNode = top;
        public boolean hasNext(){return currentNode != null;}
        public Item next()
        {
            Item currentItem= currentNode.value;
            currentNode = currentNode.next;
            return currentItem;
        }
    }
}
