import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            int[] quotes = new int[n];
            int max = -1;
            for(int i = 0; i < n; i++){
                quotes[i] = Integer.parseInt(arr[i]);
                if(max < quotes[i]){
                    max = quotes[i];
                }
            }
            bw.append(Long.toString(getMaxProfit(quotes, max))).append("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static long getMaxProfit(int[] quotes, int max) {
        int cur = 0;
        long profit = 0;

        while(cur < quotes.length){
            if(quotes[cur] < max){
                profit += max - quotes[cur];
            }
            if(quotes[cur] == max && cur + 1 < quotes.length && quotes[cur + 1] != max){
                max = -1;
                for(int i = cur + 1; i < quotes.length; i++){
                    if(max < quotes[i]){
                        max  = quotes[i];
                    }
                }
            }
            cur++;
        }

        return profit;
    }
}