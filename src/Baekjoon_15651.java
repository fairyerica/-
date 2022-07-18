//public class Backjoon_15651 {
//    public static int[] arr;
//    public static int M , N;
//    public static void solution(int depth){
//        if (depth == M){
//            for (int i = 0; i < M; i++) {
//                System.out.print(arr[i] + " ");
//            }
//            System.out.println();
//            return;
//        }
//
//        for (int i = 1; i <= N; i++) {
//            arr[depth] = i;
//            solution(depth+1);
//        }
//
//
//    }
//    public static void main(String[] args){
//        N = 4;
//        M = 2;
//        arr = new int[M];
//
//        solution(0);
//    }
//}
import java.util.*;

public class Baekjoon_15651 {

    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        arr = new int[M];

        dfs(0);
        System.out.print(sb);

    }

    public static void dfs(int depth) {
        // 깊이가 M이랑 같아지면 출력후 return
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }

}