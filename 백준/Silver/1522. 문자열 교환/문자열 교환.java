import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] charArray = br.readLine().toCharArray();

        int k = 0;
        for(char c : charArray){
            if(c == 'a') k++;
        }

        int answer = 1001;
        for(int i = 0; i < charArray.length; i++){
            int temp = 0;
            for(int j = i; j < i + k; j++){
                int idx = j % charArray.length;
                if(charArray[idx] == 'b') temp++;
            }
            answer = Math.min(answer, temp);
        }

        bw.append(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}