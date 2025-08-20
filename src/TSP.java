import java.util.*;

public class TSP {
    static int n;
    static int mincost = Integer.MAX_VALUE;
    static int dist[][];
    static boolean visited[];
    static List<Integer> bestpath = new ArrayList<>();

    public static void tsp(int currentcity, int count, int cost, List<Integer> path) {
        if (count == n && dist[currentcity][0] > 0) {
            int totalcost = cost + dist[currentcity][0];
            if (totalcost < mincost) {
                mincost = totalcost;
                bestpath = new ArrayList<>(path);
                bestpath.add(0);
            }
            return;
        }

        for (int nextcity = 0; nextcity < n; nextcity++) {
            if (!visited[nextcity] && dist[currentcity][nextcity] > 0) {
                visited[nextcity] = true;
                path.add(nextcity);
                tsp(nextcity, count + 1, cost + dist[currentcity][nextcity], path);
                visited[nextcity] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no.of cities :");
        n = sc.nextInt();

        System.out.println("enter the paths :");
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[n];

        visited[0] = true;
        List<Integer> path = new ArrayList<>();
        path.add(0);

        tsp(0, 1, 0, path);

        System.out.println("Minimum cost :" + mincost);

        System.out.println("Minimum path :");
        for (int way : bestpath) {
            System.out.print(way + "\t");
        }
        System.out.println();
    }
}

// dynamic programming

// Enter the no.of cities :
// 4
// enter the paths :
// 0 10 15 20
// 5 0 25 10
// 15 30 0 5
// 15 10 20 0
// Minimum cost :35
// Minimum path :
// 0       2       3       1       0

// O(n!)