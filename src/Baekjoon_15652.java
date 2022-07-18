import java.util.Scanner;

public class Baekjoon_15652 {
    public static int M;
    public static int N;
    public static int[] arr;


    public static void solution(int at, int depth){
        if (depth == M){
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            solution(i,depth + 1);
        }

    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        arr = new int[M];

        solution(1,0);
    }
}
