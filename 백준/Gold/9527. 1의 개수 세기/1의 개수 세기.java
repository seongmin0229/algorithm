import java.io.*;
import java.util.*;

public class Main {

    static long[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        long a = Long.parseLong(split[0]);
        long b = Long.parseLong(split[1]);

        dp = new long[55];
        dp[0] = 1;
        for(int i = 1; i < 55; i++){
            dp[i] = dp[i - 1] * 2 + (1L << i);
        }

        bw.append(String.valueOf(solve(b) - solve(a - 1)));

        bw.flush();
        bw.close();
        br.close();
    }

    private static long solve(long x) {
        long answer = x & 1L;
        for(int i = 54; i > 0; i--){
            if((x & (1L << i)) > 0L){
                answer += dp[i - 1] + x - (1L << i) + 1;
                x -= 1L << i;
            }
        }

        return answer;
    }

}
