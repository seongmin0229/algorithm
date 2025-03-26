import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] str = br.readLine().toCharArray();
        char[] rm = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length; i++){
            sb.append(str[i]);

            if(sb.length() < rm.length) continue;

            boolean match = true;
            for(int j = 0; j < rm.length; j++){
                if(sb.charAt(sb.length() - rm.length + j) != rm[j]){
                    match = false;
                    break;
                }
            }

            if(match){
                sb.delete(sb.length() - rm.length, sb.length());
            }
        }


        if(sb.length() > 0) bw.append(sb.toString());
        else bw.append("FRULA");
        bw.flush();
        bw.close();
        br.close();
    }



}
