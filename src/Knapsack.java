import java.util.*;

public class Knapsack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the no.of items :");
        int n = sc.nextInt();

        System.out.println("enter the weights and profits :");
        int Weight[] = new int[n + 1];
        int Profit[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            Weight[i] = sc.nextInt();
            Profit[i] = sc.nextInt();
        }

        System.out.println("Enter the knapsack weight :");
        int capacity = sc.nextInt();

        int M[][] = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (w < Weight[i]) {
                    M[i][w] = M[i - 1][w];
                } else {
                    M[i][w] = Math.max(M[i - 1][w], Profit[i] + M[i - 1][w - Weight[i]]);
                }
            }
        }

        int w = capacity;
        System.out.println("Obtained weight of knapsack :" + M[n][capacity]);
        for (int i = n; i > 0 && w > 0; i--) {
            if (M[i][w] != M[i - 1][w]) {
                System.out.print(i + "\t");
                w -= Weight[i];
            }
        }
        System.out.println();
    }
}

// dynamic programming

// enter the no.of items :
// 4
// enter the weights and profits :
// 3 10
// 5 4
// 6 9
// 2 11
// Enter the knapsack weight :
// 7
// Obtained weight of knapsack :21
// 4       1

// O(n*w)