import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] split = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }
        for(int k = 0; k < r; k++){
            int count = 0;
            while(count < n / 2 && count < m / 2){
                int temp = arr[count][count];
                for(int i = count; i < m - count - 1; i++){
                    arr[count][i] = arr[count][i + 1];
                }
                for(int i = count; i < n - count - 1; i++){
                    arr[i][m - count - 1] = arr[i + 1][m - count - 1];
                }
                for(int i = m - count - 1; i > count; i--){
                    arr[n - 1 - count][i] = arr[n - 1 - count][i - 1];
                }
                for(int i = n - count - 1; i > count; i--){
                    arr[i][count] = arr[i - 1][count];
                }
                arr[count + 1][count] = temp;
                count++;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bw.append(String.valueOf(arr[i][j])).append(" ");
            }
            bw.append("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
