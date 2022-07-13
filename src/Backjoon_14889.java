public class Backjoon_14889 {
    public static int N;
    public static int[][] arr;
    public static int min = Integer.MAX_VALUE;
    public static boolean[] visit;
    public static void solution(int idx, int count){
        if (count == N /2){
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]){
                visit[i] = true;
                solution(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }
    
    static void diff(){
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] == true && visit[j] == true){
                    team_start += arr[i][j];
                    team_start += arr[j][i];
                }else if (visit[i] == false && visit[j] == false){
                    team_link += arr[i][j];
                    team_link += arr[j][i];
                }
            }
        }

        int val = Math.abs(team_link - team_start);

        if (val == 0){
            System.out.println(val);
            System.exit(0);
        }
        min = Math.min(min, val);
        
    }
    public static void main(String[] args){
        N = 6;
        arr = new int[][]{{0, 1, 2, 3,4,5}, {1,0,2,3,4,5}, {1,2,0,3,4,5}, {1,2,3,0,4,5},{1,2,3,4,0,5},{1,2,3,4,5,0}};
        visit = new boolean[N];

        
        solution(0, 0);
        System.out.println(min);
    }
}
