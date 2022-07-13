import java.util.Arrays;

public class Baekjoon_15650 {
    public static boolean[] visit;
    public static int[] arr;
    public static int M;
    public static int N;

    public static void dfs(int M, int N, int at, int depth){


        if (depth == M){
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <= N; i++) {
           arr[depth] = i;
           dfs(M,N,i + 1, depth + 1);

        }

    }
    public static void main(String[] args){
        int N = 4;
        int M = 2;

        visit = new boolean[N];
        arr = new int[M];
        dfs(M,N,1,0);
    }
}
