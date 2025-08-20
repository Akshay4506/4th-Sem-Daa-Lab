import java.util.*;

class DramaRequest {
    int start, end, value;

    public DramaRequest(int s, int e, int v) {
        this.start = s;
        this.end = e;
        this.value = v;
    }
}

public class Drama {
    public static int findlastnonoverlap(DramaRequest[] request, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (request[i].start >= request[j].end) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no.of requests :");
        int n = sc.nextInt();

        System.out.println("Enter the requests :");
        DramaRequest request[] = new DramaRequest[n];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            request[i] = new DramaRequest(start, end, value);
        }

        Arrays.sort(request, Comparator.comparingInt(r -> r.end));

        int dp[] = new int[n];
        int parent[] = new int[n];

        dp[0] = request[0].value;
        parent[0] = -1;

        for (int i = 1; i < n; i++) {
            int include = request[i].value;
            int lastnonoverlap = findlastnonoverlap(request, i);
            if (lastnonoverlap != -1) {
                include += dp[lastnonoverlap];
            }

            if (include > dp[i - 1]) {
                dp[i] = include;
                parent[i] = lastnonoverlap;
            } else {
                dp[i] = dp[i - 1];
                parent[i] = parent[i - 1];
            }
        }

        System.out.println("Max Profit :" + dp[n - 1]);

        List<DramaRequest> selected = new ArrayList<>();
        int i = n - 1;
        while (i >= 0) {
            int last = findlastnonoverlap(request, i);
            int include = request[i].value + (last != -1 ? dp[last] : 0);

            if (include > (i > 0 ? dp[i - 1] : 0)) {
                selected.add(request[i]);
                i = last;
            } else {
                i--;
            }
        }

        Collections.reverse(selected);
        for (DramaRequest res : selected) {
            System.out.println(res.start + "-" + res.end + "->" + res.value);
        }
    }
}

// back tracking and dynamic programming

// Enter the no.of requests :
// 6
// Enter the requests :
// 1 2 100
// 2 5 200
// 3 6 300
// 4 8 400
// 5 9 500
// 6 10 100
// Max Profit :800
// 1-2->100
// 2-5->200
// 5-9->500

// O(elogv), O(nlogn)