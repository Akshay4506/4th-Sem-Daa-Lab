import java.util.*;

class Inv {
    public int counting(int playlist1[], int playlist2[]) {
        int n = playlist1.length;
        int pos[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pos[playlist2[i]] = i;
        }

        int mapped[] = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = pos[playlist1[i]];
        }

        return Merge(mapped, 0, n - 1);
    }

    public int Merge(int a[], int low, int high) {
        if (low >= high) {
            return 0;
        }
        int mid = (low + high) / 2;
        int count = 0;
        count += Merge(a, low, mid);
        count += Merge(a, mid + 1, high);
        count += Sort(a, low, mid, high);
        return count;
    }

    public int Sort(int a[], int low, int mid, int high) {
        int i = low;
        int h = low;
        int j = mid + 1;
        int b[] = new int[high + 1];
        int count = 0;

        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                b[h] = a[i];
                h++;
                i++;
            } else {
                b[h] = a[j];
                h++;
                j++;
                count += mid - i + 1;
            }
        }
        if (i > mid) {
            for (int k = j; k <= high; k++) {
                b[h] = a[k];
                h++;
            }
        }
        if (j > high) {
            for (int k = i; k <= mid; k++) {
                b[h] = a[k];
                h++;
            }
        }

        for (int k = low; k <= high; k++) {
            a[k] = b[k];
        }

        return count;
    }
}

public class CInv {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Inv in = new Inv();

        System.out.println("Enter no.of users :");
        int n = sc.nextInt();
        System.out.println("Enter no.of songs in the playlist :");
        int m = sc.nextInt();

        System.out.println("Enter user-1 playlist :");
        int user1[] = new int[m];
        for (int i = 0; i < m; i++) {
            user1[i] = sc.nextInt();
        }
        System.out.println("Enter user-2 playlist :");
        int user2[] = new int[m];
        for (int i = 0; i < m; i++) {
            user2[i] = sc.nextInt();
        }
        System.out.println("Enter user-3 plalyist :");
        int user3[] = new int[m];
        for (int i = 0; i < m; i++) {
            user3[i] = sc.nextInt();
        }

        int playlist[][] = { user1, user2, user3 };

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int recommended = -1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int inv = in.counting(playlist[i], playlist[j]);
                    if (min > inv) {
                        min = inv;
                        recommended = j;
                    }
                }
            }
            System.out.println("User-" + (i + 1) + " is recommended to User-" + (recommended + 1));
            System.out.println("Minimum inversions :"+min);
        }
    }
}

// divide and conquer

// Enter playlist size :
// 8
// Enter the user 1 Playlist :
// 3 1 2 5 4 6 8 7
// Enter the user 2 Playlist :
// 1 2 3 4 5 6 7 8
// Enter the user 3 Playlist :
// 8 7 6 5 4 3 2 1
// User 1 is recommended to user 2's playlist
// no.of Inversions :4
// User 2 is recommended to user 1's playlist
// no.of Inversions :4
// User 3 is recommended to user 1's playlist
// no.of Inversions :24

// O(nlogn)