import java.util.*;

public class Dijkstra {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the no.of vertices :");
        int n = sc.nextInt();

        System.out.println("enter the no.of edges :");
        int e = sc.nextInt();

        System.out.println("Enter the edges :");
        int graph[][] = new int[n][n];
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = sc.nextInt();
        }

        System.out.println("Enter the source vertex :");
        int src = sc.nextInt();

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean visited[] = new boolean[n];
        dist[src] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (graph[u][v] > 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("shortest distances :");
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print("INF\t");
            } else {
                System.out.print(dist[i] + "\t");
            }
        }
        System.out.println();
    }
}

// greedy algorithm

// enter the no.of vertices :
// 5
// enter the no.of edges :
// 6
// Enter the edges :
// 0 1 10
// 0 4 100
// 1 2 50
// 2 3 20
// 3 4 60
// 2 4 10
// Enter the source vertex :
// 0
// shortest distances :
// 0       10      60      80      70

// O(v^2)