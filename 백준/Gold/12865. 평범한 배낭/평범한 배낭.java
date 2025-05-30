import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        int[][] objects = new int[n + 1][2];
        int[][] dp = new int[n + 1][k + 1];

        for(int i = 1; i < n + 1; i++){
            String[] temp = br.readLine().split(" ");
            objects[i][0] = Integer.parseInt(temp[0]);
            objects[i][1] = Integer.parseInt(temp[1]);
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < k + 1; j++){
                int weight = objects[i][0];
                int value = objects[i][1];
                dp[i][j] = dp[i - 1][j];
                if(j - weight >= 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight] + value);
                }
            }
        }
        bw.append(String.valueOf(dp[n][k]));
        bw.flush();
        bw.close();
        br.close();

    }
}
