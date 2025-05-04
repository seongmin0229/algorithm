import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        int[] p = new int[n];

        for(int i = 0; i < n; i++){
            p[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(p);
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += p[i] * (n - i);
        }
        bw.append(String.valueOf(sum));

        bw.flush();
        bw.close();
        br.close();
    }
}
