import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] dp = new int[n + 2];

        for(int i = 1; i <= n; i++){
            String[] split = br.readLine().split(" ");
            t[i] = Integer.parseInt(split[0]);
            p[i] = Integer.parseInt(split[1]);
        }

        for(int i = 1; i <= n; i++){
            dp[i] = Math.max(dp[i], dp[i - 1]);

            if (i + t[i] - 1 <= n) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
        }

        int max = 0;
        for (int i = 1; i <= n + 1; i++) {
            max = Math.max(max, dp[i]);
        }
        bw.append(String.valueOf(max));

        bw.flush();
        bw.close();
        br.close();
    }
}
