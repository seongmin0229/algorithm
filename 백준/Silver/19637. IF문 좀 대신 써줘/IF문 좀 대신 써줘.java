import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] tier = new String[n];
        int[] limit = new int[n];

        int c = 0;
        while(c < n){
            String[] arr = br.readLine().split(" ");
            tier[c] = arr[0];
            limit[c] = Integer.parseInt(arr[1]);
            c++;
        }

        c = 0;

        while(c < m){
            int s = 0;
            int e = n - 1;
            int mid = 0;
            int score = Integer.parseInt(br.readLine());
            while(s <= e){
                mid = (s + e) / 2;
                if(score <= limit[mid]){
                    if(mid == 0 || score > limit[mid - 1]) break;
                    if(score <= limit[mid - 1]) e = mid - 1;
                }else{
                    s = mid + 1;
                }
            }
            bw.append(tier[mid]).append("\n");
            c++;
        }

        bw.flush();

//        System.out.println(Arrays.deepToString(tier));
    }
}