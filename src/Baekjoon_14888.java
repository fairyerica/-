import java.util.Scanner;

public class Baekjoon_14888 {
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static int[] operator = new int[4]; // 연산자
    public static int[] number; // 수
    public static int N; // N개의 수로 이뤄진 수열

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
//        N = 6;
        number = new int[N];

        for (int i = 0; i < N; i++) {
            number[i] = in.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operator[i] = in.nextInt();
        }
        dfs(number[0],1 );
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int num, int idx){
        if (idx == N){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0){ // 연산자가 있으면
                operator[i]--; // 연산자 빼주고

                switch (i){
                    case 0: dfs(num + number[idx], idx + 1); break;
                    case 1: dfs(num - number[idx], idx + 1); break;
                    case 2: dfs(num * number[idx], idx + 1); break;
                    case 3: dfs(num / number[idx], idx + 1); break;

                }

                operator[i]++;

            }
        }
    }
}
