import java.util.*;

class PGraph {
    public void prim(int V, int src, int G[][]) {
        boolean selected[] = new boolean[V];
        Arrays.fill(selected, false);
        selected[src] = true;

        int no_edge = 0;

        while (no_edge < V - 1) {
            int min = Integer.MAX_VALUE;
            int x = 0;
            int y = 0;
            for (int i = 0; i < V; i++) {
                if (selected[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!selected[j] && G[i][j] != 0 && G[i][j] < min) {
                            min = G[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }
            selected[y] = true;
            no_edge++;
            System.out.println(x + "->" + y + " :" + min);
        }
    }
}

public class Prim {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        PGraph pg = new PGraph();

        System.out.println("Enter the no.of vertices :");
        int V = sc.nextInt();

        System.out.println("Enter the adjacency matrix :");
        int G[][] = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                G[i][j] = sc.nextInt();
            }
        }

        System.out.println("enter the source :");
        int src = sc.nextInt();

        pg.prim(V, src, G);

    }
}

// greedy algorithm

// Enter the no.of vertices :
// 5
// Enter the adjacency matrix :
// 0 9 75 0 0
// 9 0 95 19 42
// 75 95 0 57 66
// 0 19 51 0 31
// 0 42 66 31 0
// enter the source :
// 0
// 0->1 :9
// 1->3 :19
// 3->4 :31
// 3->2 :51

// O(v^2)