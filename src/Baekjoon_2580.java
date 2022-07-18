public class Baekjoon_2580 {
    public static int[][] board;
    public static boolean[] check ;
    public static int fill;

    public static void solution(int row, int col){

        if (col == 9){ // 행 검사 쭉 하고
            solution(row + 1 , 0); // 행을 다 돌았으면 row 증가
            return;
        }
        if (row == 9){ // row 가 9 면 전체 순회 완료 했다는 뜻
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0); // 종료
        }

        if (board[row][col] == 0){ // 빈 0 찾기
            for (int i = 1; i <= 9; i++) { // 1부터 9까지
                if (isPromising(row, col, i)){ // 행과 열과 값을 입력받아서 가능한지 파악
                    board[row][col] = i; // 가능한 숫자면 집어넣음
                    solution(row, col + 1); // 다음행 검사를 위해 재귀적 호출
                }
            }
            board[row][col] = 0;
            return;
        }
        solution(row, col + 1);
    }

    public static boolean isPromising(int row, int col, int value){
        for (int j = 0; j < 9; j++) {
           if (board[row][col] == value){
               return false;
           }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value){
                return false;
            }
        }
        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (board[i][j] == value){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        board = new int[][]{
                {0, 3, 5, 4, 6, 9, 2, 7, 8},
                {7, 8, 2, 1, 0, 5, 6, 0, 9},
                {0, 6, 0, 2, 7, 8, 1, 3, 5},
                {3, 2, 1, 0, 4, 6, 8, 9, 7},
                {8, 0, 4, 9, 1, 3, 5, 0, 6},
                {5, 9, 6, 8, 2, 0, 4, 1, 3},
                {9, 1, 7, 6, 5, 2, 0, 8, 0},
                {6, 0, 3, 7, 0, 1, 9, 5, 2},
                {2, 5, 8, 3, 9, 4, 7, 6, 0}};
        solution(0,0);

    }
}
