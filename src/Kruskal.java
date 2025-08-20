import java.util.*;

public class Kruskal {
    static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static int findparent(int parent[], int u) {
        if (parent[u] != u) {
            parent[u] = findparent(parent, parent[u]);
        }
        return parent[u];
    }

    public static List<Edge> kruskals(int n, List<Edge> edges) {
        int count = 0;
        int parent[] = new int[n];
        List<Edge> mst = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        edges.sort(Comparator.comparingInt(e -> e.w));
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;

            int rootU = findparent(parent, u);
            int rootV = findparent(parent, v);

            if (rootU != rootV) {
                parent[rootU] = rootV;
                mst.add(edge);
                count++;
            }
            if (count > n - 1) {
                break;
            }
        }
        return mst;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the no.of vertices :");
        int n = sc.nextInt();

        System.out.println("Enter the no.of edges :");
        int e = sc.nextInt();

        System.out.println("enter the edges :");
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(u, v, w));
        }

        List<Edge> res = kruskals(n, edges);

        int sum = 0;
        System.out.println("Total cost :");
        for (Edge edge : edges) {
            sum += edge.w;
        }
        System.out.println(sum);

        System.out.println("Shortest path :");
        for (Edge edge : res) {
            System.out.println(edge.u + "->" + edge.v + " :" + edge.w);
        }
    }
}

// greedy algorithm

// enter the no.of vertices :
// 5
// Enter the no.of edges :
// 7
// enter the edges :
// 0 1 10
// 0 4 5
// 1 2 1
// 1 3 6
// 2 3 2
// 2 4 7
// 3 4 3
// Total cost :
// 34
// Shortest path :
// 1->2 :1
// 2->3 :2
// 3->4 :3
// 0->4 :5

// O(eloge)