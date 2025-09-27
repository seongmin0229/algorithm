import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 일일이 계산 말고는 안떠오르는데
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Town[] towns = new Town[n];
        long total = 0L;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            towns[i] = new Town(x, a);
            total += a;
        }

        Arrays.sort(towns, Comparator.comparingInt(t -> t.x));

        long sum = 0L;
        long threshold = (total + 1) / 2;

        for(int i = 0; i < n; i++){
            sum += towns[i].a;
            if(threshold <= sum){
                System.out.println(towns[i].x);
                return;
            }
        }

    }

    static class Town{
        int x;
        long a;

        Town(int x, long a){
            this.x = x;
            this.a = a;
        }
    }
}
