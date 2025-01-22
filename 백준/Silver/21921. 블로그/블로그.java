import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NX = br.readLine().split(" ");
        int N = Integer.parseInt(NX[0]);
        int X = Integer.parseInt(NX[1]);

        String[] arr = br.readLine().split(" ");
        int[] visitors = new int[N];
        for(int i = 0; i < N; i++){
            visitors[i] = Integer.parseInt(arr[i]);
        }

        int max = 0;
        for(int i = 0; i < X; i++){
            max += visitors[i];
        }
        int cur = max;

        int counter = 1;
        for(int i = 1; i < N - X + 1; i++){
            cur = cur - visitors[i - 1] + visitors[i + X - 1];
            if(max < cur) {
                max = cur;
                counter = 1;
            } else if (max == cur) {
                counter++;
            }
        }

        if(max == 0){
            bw.append("SAD");
        }else{
            bw.append(max + "\n" + counter);
        }
        bw.flush();
    }

}