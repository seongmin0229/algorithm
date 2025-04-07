import java.io.*;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] children = new int[n];
        int[][] DP = new int[n][2];
        DP[0][0] = 1;
        DP[0][1] = 0;

        for(int i = 0; i < n; i++){
            children[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i < n; i++){
            int k = i - 1;
            int max = -1;
            while(k >= 0){
                if(children[k] < children[i] && max < DP[k][0]){
                    max = DP[k][0];
                }
                k--;
            }
            if(max == -1) {
                DP[i][0] = 1;
            }
            else {
                DP[i][0] = max + 1;
            }
            DP[i][1] = Integer.max(DP[i - 1][0], DP[i - 1][1]);
        }

        bw.append(String.valueOf(n - Integer.max(DP[n - 1][0], DP[n - 1][1])));


        bw.flush();
        bw.close();
        br.close();
    }

}
