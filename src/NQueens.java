import java.util.*;

class Chess {
    int size;
    int board[];
    int count = 0;

    public Chess(int size) {
        this.size = size;
        this.board = new int[size];
    }

    public void sol() {
        solveRecursive(0);
        System.out.println("total solutions :" + count);
    }

    public void solveRecursive(int row) {
        if (row == size) {
            printBoard();
            count++;
            return;
        }

        for (int col = 0; col < size; col++) {
            if (isSafe(row, col)) {
                board[row] = col;
                solveRecursive(row + 1);
            }
        }
    }

    public boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        System.out.println("Solution-" + (count + 1));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String res = (board[i] == j ? "Q" : ".");
                System.out.print(res + "\t");
            }
            System.out.println();
        }
    }
}

public class NQueens {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the board :");
        int size = sc.nextInt();
        Chess ch = new Chess(size);

        ch.sol();
    }
}

// backtracking

// Enter the size of the board :
// 4
// Solution-1
// .       Q       .       .
// .       .       .       Q
// Q       .       .       .
// .       .       Q       .
// Solution-2
// .       .       Q       .
// Q       .       .       .
// .       .       .       Q
// .       Q       .       .
// total solutions :2

// O(n!)