public class Baekjoon_15649 {
    public static int[] arr;
    public static boolean[] visit;
    public static int solution(int N, int M){

        return 0;
    }

    public static void dfs(int N, int M, int depth){
        if (depth == M) {
            for (int val : arr){
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]){
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int N = 4;
        int M = 2;
        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);
    }
}
