import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];
        for(int i = 1; i < k + 1; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i < k + 1; i++){
            for(int j = 0; j < n; j++){
                if(i - coins[j] < 0 || dp[i - coins[j]] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }

        if(dp[k] == Integer.MAX_VALUE) bw.append("-1");
        else bw.append(String.valueOf(dp[k]));
        bw.flush();
        bw.close();
        br.close();
    }
}
