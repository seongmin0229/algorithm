import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]);
        int c = Integer.parseInt(split[1]);

        int[] arr = new int[n];
        boolean[] s = new boolean[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int answer = -1;
        int start = 1;
        int end = arr[n - 1] - arr[0];

        while(start <= end){
            int mid = (start + end) / 2;

            int count = 1;
            int lastIdx = 0;
            for(int i = 1; i < n; i++){
                if(arr[i] - arr[lastIdx] >= mid){
                    count++;
                    lastIdx = i;
                }
            }

            if(count >= c){
                answer = Integer.max(answer, mid);
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        bw.append(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }



}
