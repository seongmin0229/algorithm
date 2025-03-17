import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");

        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(nums);

        int answer = 0;

        for(int i = 0; i < n; i++){
            int start = 0;
            int end = n - 1;

            while(start < end){
                if(start == i){
                    start++;
                    continue;
                }
                if(end == i){
                    end--;
                    continue;
                }

                if(nums[start] + nums[end] == nums[i]){
                    answer++;
                    break;
                }

                if(nums[start] + nums[end] < nums[i]){
                    start++;
                }else{
                    end--;
                }
            }
        }

        bw.append(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

}
