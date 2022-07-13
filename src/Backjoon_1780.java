

public class Backjoon_1780 {
    public static int[][] board;
    public static int GRAY = 0;		// -1에 해당
    public static int WHITE = 0;	// 0에 해당
    public static int BLACK = 0;	// 1에 해당

    public static void partition(int row, int col, int size){
        if (colorCheck(row,col,size)){
            if (board[row][col] == -1){
                GRAY++;
            }else if (board[row][col] == 0){
                WHITE++;
            }else{
                BLACK++;
            }
            return;
        }
        int newSize = size / 3;

        partition(row, col, newSize);								// 왼쪽 위
        partition(row, col + newSize, newSize);						// 중앙 위
        partition(row, col + 2 * newSize, newSize);					// 오른쪽 위

        partition(row + newSize, col, newSize);						// 왼쪽 중간
        partition(row + newSize, col + newSize, newSize);			// 중앙 중간
        partition(row + newSize, col + 2 * newSize, newSize);		// 오른쪽 중간

        partition(row + 2 * newSize, col, newSize);					// 왼쪽 아래
        partition(row + 2 * newSize, col + newSize, newSize);		// 중앙 아래
        partition(row + 2 * newSize, col + 2 * newSize, newSize);	// 오른쪽 아래



    }
    public static boolean colorCheck(int row, int col, int size){
        int color = board[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != board[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        int N = 9;

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                board[i][j] = in.nextInt();
//            }
//        }
        board = new int[][]{{0, 0, 0, 1, 1, 1, -1, -1, -1}, {0, 0, 0, 1, 1, 1, -1, -1, -1}
        ,{0, 0, 0, 1, 1, 1, -1, -1, -1},{1,1,1,0,0,0,0,0,0},{1,1,1,0,0,0,0,0,0},{1,1,1,0,0,0,0,0,0}
        ,{0,1,-1,0,1,-1,0,1,-1},{0,-1,1,0,1,-1,0,1,-1},{0,1,-1,1,0,-1,0,1,-1}};
        partition(0,0,N);
        System.out.println(GRAY);	// -1
        System.out.println(WHITE);	// 0
        System.out.println(BLACK);	// 1

    }
}
