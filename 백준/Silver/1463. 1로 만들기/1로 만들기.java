import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        if(n > 1) dp[2] = 1;
        if(n > 2) {
            dp[3] = 1;
            for(int i = 4; i <= n; i++){
                dp[i] = dp[i - 1] + 1;
                if(i % 2 == 0){
                    dp[i] = Math.min(dp[i], dp[i / 2] + 1);
                }

                if(i % 3 == 0){
                    dp[i] = Math.min(dp[i], dp[i / 3] + 1);
                }
            }
        }
        bw.append(String.valueOf(dp[n]));

        bw.flush();
        bw.close();
        br.close();
    }
}
