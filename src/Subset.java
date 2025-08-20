import java.util.*;

public class Subset {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no.of items :");
        int n = sc.nextInt();

        System.out.println("Enter the weights :");
        int weights[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            weights[i] = sc.nextInt();
        }

        System.out.println("Enter max value of subset :");
        int sum = sc.nextInt();

        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= sum; w++) {
                if (w < weights[i]) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = (dp[i - 1][w] || dp[i - 1][w - weights[i]]);
                }
            }
        }

        int closest = -1;
        for (int i = sum; i > 0; i++) {
            if (dp[n][i]) {
                closest = i;
                break;
            }
        }

        if (closest == -1) {
            System.out.println("No such subset exists");
        } else {
            System.out.println("Shortest path :" + closest);

            List<Integer> subset = new ArrayList<>();
            int i = n;
            int j = sum;
            while (i > 0 && j > 0) {
                if (dp[i][j] && !dp[i - 1][j]) {
                    subset.add(i);
                    j -= weights[i];
                }
                i--;
            }
            System.out.println("subset :");
            for (int num : subset) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}

// dynamic programming

// Enter no.of items :
// 6
// Enter the weights :
// 1200
// 500
// 700
// 300
// 900
// 1500
// Enter max value of subset :
// 2000
// Shortest path : 2000
// Subset:
// 4   2   1


// O(n*t)