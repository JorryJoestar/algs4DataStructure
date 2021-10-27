package collections.api;

public abstract class Stack<Item> implements Iterable<Item>
{
    public abstract void    push(Item item);
    public abstract Item    pop();
    public abstract Item    top();
    public abstract boolean isEmpty();
    public abstract int     size();
}
