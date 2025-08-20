import java.util.*;

class Gale {
    public void matching(int n, int menpref[][], int womenpref[][]) {
        int partner[] = new int[n];
        boolean freemen[] = new boolean[n];
        Arrays.fill(partner, -1);
        Arrays.fill(freemen, false);
        int freecount = n;

        while (freecount > 0) {
            int man;
            for (man = 0; man < n; man++) {
                if (!freemen[man]) {
                    break;
                }
            }
            for (int i = 0; i < n && !freemen[man]; i++) {
                int woman = menpref[man][i];
                if (partner[woman] == -1) {
                    partner[woman] = man;
                    freemen[man] = true;
                    freecount--;
                } else {
                    int current = partner[woman];
                    if (prefersnewman(current, womenpref[i], man)) {
                        partner[woman] = man;
                        freemen[man] = true;
                        freemen[current] = false;
                    }
                }
            }
        }
        System.out.println("Matched pairs :");
        for (int i = 0; i < n; i++) {
            System.out.println("Woman-" + i + " is paired to Man-" + partner[i]);
        }
    }

    public boolean prefersnewman(int currentman, int womenpref[], int newman) {
        for (int man : womenpref) {
            if (man == newman) {
                return true;
            } else if (man == currentman) {
                return false;
            }
        }
        return false;
    }
}

public class GaleShapley {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Gale g = new Gale();

        System.out.println("Enter the no.of men/women :");
        int n = sc.nextInt();

        System.out.println("Enter the men preferences :");
        int menpref[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                menpref[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the women preferences :");
        int womenpref[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                womenpref[i][j] = sc.nextInt();
            }
        }

        g.matching(n, menpref, womenpref);
    }
}

// greedy algorithm

// Enter the no.of men/women :
// 3
// Enter the men preferences :
// 0 1 2
// 1 0 2
// 0 1 2
// Enter the women preferences :
// 0 1 2
// 1 2 0
// 2 0 1
// Matched pairs :
// Woman-0 is paired to Man-0
// Woman-1 is paired to Man-1
// Woman-2 is paired to Man-2

// O(n^2)