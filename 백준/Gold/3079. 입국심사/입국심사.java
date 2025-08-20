import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] t = new int[n];
        int maxT = 0;
        for(int i = 0; i < n; i++){
            t[i] = Integer.parseInt(br.readLine());
            maxT = Math.max(maxT, t[i]);
        }

        long l = 1;
        long r = (long) m * maxT;
        long answer = r;

        while(l <= r){
            long mid = (l + r) / 2;

            long available = 0;
            for (int time : t) {
                available += mid / time;
                if(available >= m) break;
            }

            if(available >= m){
                answer = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
