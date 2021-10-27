package collections.api;

public abstract class Queue<Item> implements Iterable<Item>
{
    public abstract void    enQueue(Item item);
    public abstract Item    deQueue();
    public abstract boolean isEmpty();
    public abstract int     size();
}

