import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[50001];

        int t = 3;
        while(t > 0){
            Arrays.fill(dp, 0);
            dp[0] = 1;
            int n = Integer.parseInt(br.readLine());
            int[][] coins = new int[n][2];
            int sum = 0;

            for(int i = 0; i < n; i++){
                String[] split = br.readLine().trim().split("\\s+");
                coins[i][0] = Integer.parseInt(split[0]);
                coins[i][1] = Integer.parseInt(split[1]);
                sum += (coins[i][0] * coins[i][1]);
            }
            if(sum % 2 == 1) {
                bw.append("0\n");
                t--;
                continue;
            }
            int aside = sum / 2;

            for (int[] coin : coins) {
                int kind = coin[0];
                int cnt = coin[1];

                for(int j = aside; j >= kind; j--){
                    if(dp[j - kind] == 1){
                        for(int k = 0; k < cnt && (j + kind * k <= aside); k++){
                            dp[j + kind * k] = 1;
                        }
                    }
                }
            }
            bw.append(String.valueOf(dp[aside])).append("\n");
            t--;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
