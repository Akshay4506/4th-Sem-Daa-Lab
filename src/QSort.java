import java.util.*;

class Ord {
    public int partition(int a[], int low, int high) {
        int pivot = a[low];
        int i = low + 1;
        int j = high;

        while (i <= j) {
            while (i <= high && pivot >= a[i]) {
                i++;
            }
            while (j >= low && a[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[low];
        a[low] = a[j];
        a[j] = temp;

        return j;
    }

    public void quick(int a[], int low, int high) {
        if (low >= high) {
            return;
        }
        int j = partition(a, low, high);
        quick(a, low, j - 1);
        quick(a, j + 1, high);
    }
}

public class QSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Ord od = new Ord();

        System.out.println("Enter the no.of elements :");
        int n = sc.nextInt();

        System.out.println("Enter the elements :");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int low = 0;
        int high = n - 1;

        od.quick(a, low, high);

        System.out.println("Sorted array :");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }
}

// divide and conquer

// Enter no.of elemnets :
// 8
// Enter the elements :
// 5 3 1 9 8 2 4 7
// Sorted array :
// 1 2 3 4 5 7 8 9

// O(nlogn)