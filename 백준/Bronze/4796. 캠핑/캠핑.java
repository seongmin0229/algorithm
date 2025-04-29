import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;

        while(true){
            count++;
            String[] split = br.readLine().split(" ");
            int l = Integer.parseInt(split[0]);
            int p = Integer.parseInt(split[1]);
            int v = Integer.parseInt(split[2]);

            if(l == 0) break;

            int a = (v / p) * l;
            int b = Math.min(v % p, l);
            bw.append("Case ").append(String.valueOf(count)).append(": ").append(String.valueOf(a + b)).append("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
