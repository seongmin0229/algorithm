import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]);
        int s = Integer.parseInt(split[1]);

        int[] arr = new int[n];
        String[] split1 = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(split1[i]);
        }

        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        int sum = arr[0];

        while(start <= end){
            if(sum >= s){
                min = Math.min(min, end - start + 1);
                sum -= arr[start];
                start++;
            }else{
                end++;
                if(end == n) break;
                sum += arr[end];
            }
        }

        if(min == Integer.MAX_VALUE) min = 0;

        bw.append(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

}
