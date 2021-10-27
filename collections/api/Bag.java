package collections.api;

public abstract class Bag<Item> implements Iterable<Item>
{
    public abstract void    add(Item item);
    public abstract boolean isEmpty();
    public abstract int     size();
}
