import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 이분 탐색 너무 어려워요
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] location = new int[n + 2];
        location[0] = 0;
        location[n + 1] = l;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++){
            location[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(location);

        int start = 1;
        int end = l - 1;
        int answer = 9999;

        while(start <= end){
            int mid = (start + end) / 2;
            int count = 0;

            for(int i = 0; i < n + 1; i++){
                int distance = location[i + 1] - location[i];
                count += distance / mid;
                if(distance % mid == 0) count -= 1;
            }

            if(count <= m){
                answer = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(answer);

    }
}
