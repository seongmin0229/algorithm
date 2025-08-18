import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[c + 100];
        int[][] cities = new int[n][2];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < n; i++){
            String[] split = br.readLine().split(" ");
            cities[i][0] = Integer.parseInt(split[0]);
            cities[i][1] = Integer.parseInt(split[1]);
        }
        Arrays.sort(cities, Comparator.comparingInt(x -> x[0]));

        Arrays.sort(cities, Comparator.comparingDouble(x -> (double) x[0] / x[1]));

        for(int i = 1; i < c + 100; i++){
            for(int[] city : cities){
                if(i - city[1] >= 0 && dp[i - city[1]] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i - city[1]] + city[0]);
            }
        }

        int answer = Arrays.stream(Arrays.copyOfRange(dp, c, c + 100)).min().getAsInt();
        System.out.println(answer);
    }
}
