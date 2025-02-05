import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        char[] charArr = br.readLine().toCharArray();


        // n이 1인 경우
        if(n == 1) bw.append(Integer.toString(0));
        else {
            // n이 1보다 큰 경우
            int start = 0;
            int end = charArr.length - 1;
            if(charArr[start] != charArr[end]){
                // 처음과 끝의 문자가 다른 경우
                while(charArr[start + 1] == charArr[0]){
                    // 앞 중복 제거
                    start++;
                }
                while(charArr[end - 1] == charArr[charArr.length - 1]) {
                    // 뒷 중복 제거
                    end--;
                }
                if(start == end - 1){
                    // 이미 끼리끼리 뭉쳐있는 경우
                    bw.append(Integer.toString(0));
                }else{
                    // 안 뭉쳐있는 경우
                    int b = 0;
                    int r = 0;
                    for(int i = start + 1; i < end; i++){
                        if(charArr[i] == 'B') b++;
                        else r++;
                    }
                    bw.append(Integer.toString(Math.min(b, r)));
                }
            }else{
                // 처음과 끝의 문자가 같은 경우
                int s = 0;
                int e = 0;
                while(start < charArr.length - 1 && charArr[start + 1] == charArr[0]){
                    // 앞 중복 제거
                    start++;
                    s++;
                }
                while(end > 0 && charArr[end - 1] == charArr[charArr.length - 1]) {
                    // 뒷 중복 제거
                    end--;
                    e++;
                }
                if(start == charArr.length - 1) bw.append(Integer.toString(0)); // 모든 문자가 같은 경우
                else{
                    if(s > e){
                        start++;
                        end = charArr.length - 1;
                    }else{
                        start = 0;
                        end--;
                    }
                    int b = 0;
                    int r = 0;
                    for(int i = start; i <= end; i++){
                        if(charArr[i] == 'B') b++;
                        else r++;
                    }
                    bw.append(Integer.toString(Math.min(b, r)));
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}