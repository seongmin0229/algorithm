import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());

            int[][] stickers = new int[n][2];
            String[] line1 = br.readLine().split(" ");
            String[] line2 = br.readLine().split(" ");
            for(int i = 0; i < n; i++){
                stickers[i][0] = Integer.parseInt(line1[i]);
                stickers[i][1] = Integer.parseInt(line2[i]);
            }

            int[][] dp = new int[n][2];
            dp[0][0] = stickers[0][0];
            dp[0][1] = stickers[0][1];

            if(n > 1){
                dp[1][0] = dp[0][1] + stickers[1][0];
                dp[1][1] = dp[0][0] + stickers[1][1];
            }

            for(int i = 2; i < n; i++){
                dp[i][0] = Math.max(Math.max(dp[i - 2][0], dp[i - 2][1]), dp[i - 1][1]) + stickers[i][0];
                dp[i][1] = Math.max(Math.max(dp[i - 2][0], dp[i - 2][1]), dp[i - 1][0]) + stickers[i][1];
            }

            bw.append(String.valueOf(Math.max(dp[n - 1][0], dp[n - 1][1])));
            bw.append("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
