import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        String[] split = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(split[i]);
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(a[j] > a[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        bw.append(String.valueOf(Arrays.stream(dp).max().getAsInt()));

        bw.flush();
        bw.close();
        br.close();
    }
}
