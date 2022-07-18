
import java.io.IOException;
import java.util.Scanner;

public class Baekjoon_9663 {
    static int n;
    static int[] board;
    static int cnt;

    public static int solution(int row) {
        if (row == n){
            cnt++;
            return cnt;
        }
        for (int i = 0; i < n; i++) {
            board[row] = i;

            if (isPromising(row)){
                solution(row + 1);
            }
        }
        return cnt;
    }
    public static boolean isPromising(int row){
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        board = new int[n];
        solution(0);
        System.out.println(cnt);

    }
}