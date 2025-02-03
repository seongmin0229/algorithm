import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);

        String[] strArr = br.readLine().split(" ");

        int[] numArr = new int[n];
        int[] count = new int[100001];

        for(int i = 0; i < n; i++){
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        int st = 0;
        int end = 0;
        int length = 0;

        while(st < n){
            if(count[numArr[st]] < k){
                count[numArr[st]] += 1;
                st++;
            }else{
                while(count[numArr[st]] == k){
                    count[numArr[end]] -= 1;
                    end++;
                }
            }
            length = Integer.max(length,st - end);
        }

        System.out.println(length);

        bw.flush();
        bw.close();
        br.close();
    }

}