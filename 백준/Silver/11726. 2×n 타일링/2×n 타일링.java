import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[] DP = new long[n + 1];

        if(n > 0){
            DP[1] = 1;
        }

        if(n > 1){
            DP[2] = 2;
            for(int i = 3; i <= n; i++){
                DP[i] = (DP[i - 1] + DP[i - 2]) % 10007;
            }
        }

        bw.append(String.valueOf(DP[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
