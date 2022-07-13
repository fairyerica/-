import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_2309 {
    public static void main(String[] args) throws IOException {
        int[] dwarfs = {20,7,23,19,10,15,25,8,13};
        int sum = 0;
        int max = 100;
        for (int i = 0; i < dwarfs.length; i++) {
            sum += dwarfs[i];
        }

        for (int i = 0; i < dwarfs.length; i++) {
            for (int j = i + 1; j < dwarfs.length; j++) {
                if (sum - (dwarfs[i] + dwarfs[j]) == max){
                    dwarfs[i] = Integer.MIN_VALUE;
                    dwarfs[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        Arrays.sort(dwarfs);
        for (int i : dwarfs){
            if (i != Integer.MIN_VALUE){
                System.out.println(i);
            }
        }


    }

}
