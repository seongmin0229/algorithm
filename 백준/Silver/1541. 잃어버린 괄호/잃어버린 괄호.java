
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringBuilder num = new StringBuilder();
        int sum = 0;

        boolean minusFlag = false;

        for(int i = 0; i < line.length(); i++){
            char cur = line.charAt(i);
            if(cur != '-' && cur != '+'){
                num.append(cur);
                if(i != line.length() - 1) continue;
            }

            if(minusFlag){
                sum -= Integer.parseInt(num.toString());
            }else{
                sum += Integer.parseInt(num.toString());
            }
            num = new StringBuilder();


            if(cur == '-'){
                minusFlag = true;
            }
        }
        bw.append(String.valueOf(sum));

        bw.flush();
        bw.close();
        br.close();
    }
}
