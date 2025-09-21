import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 하나의 꿀벌과 꿀통은 서로 양극단에 위치하고
         * 남은 하나의 꿀벌의 위치를 옮겨가면서 최대값을 구하는데, 누적합을 활용
         *
         * 벌통이 가운데 위치할 수 있는 경우도 있음...
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] s = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            s[i] = Integer.parseInt(st.nextToken());
        }

        int max = calculateMax(s);
        int[] reversed = new int[s.length];
        for(int i = 0; i < s.length; i++){
            reversed[i] = s[s.length - i - 1];
        }
        max = Math.max(max, calculateMax(reversed));
        max = Math.max(max, calculateMax2(s));
        System.out.println(max);
    }

    private static int calculateMax2(int[] s) {
        int[] ps = new int[s.length];
        ps[0] = s[0];
        for(int i = 1; i < ps.length; i++){
            ps[i] = ps[i - 1] + s[i];
        }
        int max = 0;
        for(int i = 1; i < s.length - 1; i++){
            max = Math.max(max, (ps[i] - ps[0]) + (ps[ps.length - 2] - ps[i - 1]));
        }

        return max;
    }

    private static int calculateMax(int[] s) {
        int[] ps = new int[s.length];
        ps[0] = s[0];
        for(int i = 1; i < ps.length; i++){
            ps[i] = ps[i - 1] + s[i];
        }

        int max = 0;
        int c1 = ps[ps.length - 1] - s[0];
        int c2 = ps[ps.length - 1] - s[0];
        for(int i = 1; i < s.length - 1; i++){
            max = Math.max(max, c1 + c2 - s[i] - ps[i] + s[0]);
        }

        return max;
    }


}
