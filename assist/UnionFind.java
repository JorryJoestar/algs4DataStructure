package assist;

public class UnionFind
{
    private static int N;
    private int count;
    private int[] id;
    private int[] size;

    public UnionFind(int N)
    {
        this.N = N;
        this.count = N;
        id = new int[N];
        size = new int[N];
        for(int i=0;i<N;i++) id[i] = i;
        for(int i=0;i<N;i++) size[i] = 1;
    }
    public void union(int p,int q)
    {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;
        if(size[rootP]>size[rootQ])
        {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
            count--;
        }
        else
        {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
            count--;
        }
    }
    public int find(int p)
    {
        int currentP = p;
        while(id[currentP]!=currentP) currentP = id[currentP];
        return currentP;
    }
    public boolean connected(int p,int q){return find(p)==find(q);}
    public int count(){return this.count;}
}
