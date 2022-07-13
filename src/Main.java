import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        int[] arr = {1,2,3,4,2,5,3,1,1,2};
//        int n = 10;
//        int m = 5;


        int start = 0;
        int end = 0;
        int cnt = 0;
        int sum = 0;

        while(start < n) {
            if (end == n) break;
            sum += arr[end++];
            while (sum > m){
                sum -= arr[start++];
            }
            if (sum == m){
                cnt++;
            }

        }
        System.out.println(cnt);
    }
}