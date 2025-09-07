import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int J = 0;
    static final int O = 1;
    static final int I = 2;
    public static void main(String[] args) throws IOException {
        /**
         * 각 좌표에 대해서 누적합을 구하고
         * 영역이 주어지면, 영역을 빼고 더해서 값 구하는게 아닐까 하는 아이디어
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        int[][][] sector = new int[n + 1][m + 1][3];

        for(int i = 1; i < n + 1; i++){
            String s = br.readLine();
            int jungle = 0, ocean = 0, ice = 0;
            for(int j = 1; j < m + 1; j++){
                if(s.charAt(j - 1) == 'J') jungle++;
                if(s.charAt(j - 1) == 'O') ocean++;
                if(s.charAt(j - 1) == 'I') ice++;
                sector[i][j][J] += sector[i - 1][j][J] + jungle;
                sector[i][j][O] += sector[i - 1][j][O] + ocean;
                sector[i][j][I] += sector[i - 1][j][I] + ice;

            }
        }


        StringBuilder sb = new StringBuilder();
        int[] result = new int[3];
        for(int i = 0; i < k; i++){
            Arrays.fill(result, 0);
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            add(result, sector[x2][y2]);
            sub(result, sector[x1 - 1][y2]);
            sub(result, sector[x2][y1 - 1]);
            add(result, sector[x1 - 1][y1 - 1]);

            sb.append(result[J]).append(" ").append(result[O]).append(" ").append(result[I]).append("\n");
        }
        System.out.println(sb);

    }
    static void add(int[] a, int[] b){
        for (int t = 0; t < a.length; t++) a[t] += b[t];
    }

    static void sub(int[] a, int[] b){
        for (int t = 0; t < a.length; t++) a[t] -= b[t];
    }
}
