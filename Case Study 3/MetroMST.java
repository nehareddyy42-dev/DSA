import java.util.*;

class Edge implements Comparable<Edge> {

    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class UnionFind {

    int parent[];

    UnionFind(int n) {

        parent = new int[n];

        for(int i=0;i<n;i++)
            parent[i] = i;
    }

    int find(int x) {

        if(parent[x] == x)
            return x;

        return find(parent[x]);
    }

    boolean union(int x, int y) {

        int px = find(x);
        int py = find(y);

        if(px == py)
            return false;

        parent[px] = py;
        return true;
    }
}

public class MetroMST {

    public static void main(String[] args) {

        ArrayList<Edge> edges =
                new ArrayList<>();

        edges.add(new Edge(0,1,4));
        edges.add(new Edge(0,2,5));
        edges.add(new Edge(1,2,6));
        edges.add(new Edge(1,3,7));
        edges.add(new Edge(2,3,8));
        edges.add(new Edge(2,4,9));
        edges.add(new Edge(3,4,10));
        edges.add(new Edge(3,5,11));
        edges.add(new Edge(4,5,12));

        Collections.sort(edges);

        UnionFind uf =
                new UnionFind(6);

        int totalCost = 0;

        System.out.println(
                "Selected MST Edges:");

        for(Edge e : edges) {

            if(uf.union(
                    e.src,
                    e.dest)) {

                System.out.println(
                        e.src + " - " +
                        e.dest +
                        " : " +
                        e.weight);

                totalCost +=
                        e.weight;
            }
        }

        System.out.println(
                "\nTotal Cost = "
                        + totalCost);
    }
}