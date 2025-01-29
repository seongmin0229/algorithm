import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);

        int cur = sb.length();

        int m = Integer.parseInt(br.readLine());

        while(m-- > 0){
            String line = br.readLine();
            char[] op = line.toCharArray();
            if(op[0] == 'P'){
                char c = op[2];
                sb.insert(cur, c);
                cur++;
            }

            if(op[0] == 'L'){
                if(cur != 0){
                    cur--;
                }
            }

            if(op[0] == 'D'){
                if(cur != sb.length()){
                    cur++;
                }
            }

            if(op[0] == 'B'){
                if(cur != 0){
                    sb.deleteCharAt(cur - 1);
                    cur--;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}