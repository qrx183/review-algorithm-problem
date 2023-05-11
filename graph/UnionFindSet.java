package graph;

public class UnionFindSet {
    int[] fa,rank;
    public void init(int n) {
        fa = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            fa[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if(x == fa[x]) {
            return x;
        }
        fa[x] = find(fa[x]);
        return fa[x];
    }

    public void union(int x,int y) {
        fa[find(x)] = find(y);
    }

    public void unionByRank(int x,int y) {
        int faX = find(x), faY = find(y);
        if(faX == faY){
            return;
        }
        if(rank[faX] <= rank[faY]) fa[faX] = faY;
        else fa[faY] = faX;
        if(rank[faX] == rank[faY]) rank[faY]++;
    }
}
