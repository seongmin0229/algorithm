import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        char[] sArray = s.toCharArray();

        int count0 = 0;
        int count1 = 0;
        for(char a : sArray){
            if(a == '0'){
                count0++;
            }else{
                count1++;
            }
        }
        count0 /= 2;
        count1 /= 2;

        for(int i = sArray.length - 1; i >= 0; i--){
            if(count0 == 0) break;
            if(sArray[i] == '0'){
                sArray[i] = 'X';
                count0--;
            }
        }
        for(int i = 0; i < sArray.length; i++){
            if(count1 == 0) break;
            if(sArray[i] == '1'){
                sArray[i] = 'X';
                count1--;
            }
        }

        StringBuilder sPrime = new StringBuilder();
        for(char a : sArray){
            if(a != 'X'){
                sPrime.append(a);
            }
        }
        System.out.println(sPrime);

    }
}