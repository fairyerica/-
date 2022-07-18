public class Baekjoon_2630 {
    public static int[][] board;
    public static int a = 0; // 하얀색 0
    public static int b = 0; // 파란색 -1
    public static void divide(int row, int col, int size){
        if (colorCheck(row,col,size)){
            if (board[row][col] == 0){
                a++;
            }else{
                b++;
            }
            return;
        }

        int newSize = size / 2;
        divide(row,col,newSize);

        divide(row,col + newSize,newSize);
        divide(row + newSize,col,newSize);
        divide(row + newSize,col + newSize ,newSize);


    }
    public static boolean colorCheck(int row, int col, int size){
        int color = board[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        int N = 8;
        board = new int[][]{{1, 1, 0, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1, 1, 1}};
        divide(0,0,N);
        System.out.println(a);
        System.out.println(b);

    }
}
