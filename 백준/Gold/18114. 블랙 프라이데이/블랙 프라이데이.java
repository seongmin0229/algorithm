import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * 내 아이디어...
         * 떠오르지... 않는다...
         *
         * 1. 완전 탐색 -> 제한 시간 1초라서 ㅂㄱㄴ
         * 2. 이분 탐색을 해야하는데 start, mid, end를 두고 start와 end의 값이 계속 바뀌는걸로?
         * 해봤는데 절대 아닌듯
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] w = new int[n];

        String[] split = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            w[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(w);

        boolean isExist = false;

        // case 1 : 하나로 가능할 때
        if(Arrays.binarySearch(w, c) >= 0){
            isExist = true;
        }
        
        
        // case 2 : 두개로 가능할 때
        int s = 0, e = n - 1;

        while(!isExist && s < e){

            long v = (long) w[s] + w[e];

            if(v == c){
                isExist = true;
                break;
            }

            if(v > c){
                e--;
            }else{
                s++;
            }
        }

        // case 3 : 세개로 가능할 때
        int i = 0;
        while(!isExist && i < n){

            if(w[i] >= c) break;

            int target = c - w[i];
            s = i + 1;
            e = n - 1;

            while(s < e){
                
                long v = (long) w[s] + w[e];
                
                if(v == target){
                    isExist = true;
                    break;
                }

                if(v > c){
                    e--;
                }else{
                    s++;
                }
            }


            i++;
        }

        if(isExist){
            bw.append("1");
        }else{
            bw.append("0");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
