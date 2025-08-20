import java.util.*;

class Top {
    int vertices;
    ArrayList<ArrayList<Integer>> adj;

    public Top(int vertices) {
        this.vertices = vertices;
        this.adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public void topological() {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        System.out.println("sorted array :");
        for (int i = 0; i < vertices; i++) {
            System.out.print(res.get(i) + "\t");
        }
        System.out.println();
    }

    public void dfs(int vertex, boolean visited[], Stack<Integer> stack) {
        visited[vertex] = true;
        for (int neighbour : adj.get(vertex)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, stack);
            }
        }
        stack.push(vertex);
    }
}

public class TopSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no.of vertices :");
        int vertices = sc.nextInt();

        Top tp = new Top(vertices);

        System.out.println("enter the no.of edges :");
        int n = sc.nextInt();

        System.out.println("Enter the edges :");
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tp.addEdge(u, v);
        }

        tp.topological();
    }
}

// dfs based traversal

// Enter the no.of vertices :
// 6
// enter the no.of edges :
// 6
// Enter the edges :
// 2 3
// 3 1
// 4 0
// 4 1
// 5 0
// 5 2
// sorted array :
// 5       4       2       3       1       0

// O(v+e)