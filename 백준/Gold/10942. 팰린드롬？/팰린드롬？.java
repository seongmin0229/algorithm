import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 2][n + 2];
        for(int i = 1; i < n + 2; i++){
            dp[i][i] = 1;
            if(i < n + 1) dp[i + 1][i] = 1;
        }

        String[] split = br.readLine().split(" ");
        int[] sequence = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();

        for(int s = n; s > 0; s--){
            for(int e = s + 1; e < n + 1; e++){
                if(sequence[s - 1] == sequence[e - 1]){
                    dp[s][e] = dp[s + 1][e - 1];
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            String[] temp = br.readLine().split(" ");
            int s = Integer.parseInt(temp[0]);
            int e = Integer.parseInt(temp[1]);
            bw.append(String.valueOf(dp[s][e])).append("\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
