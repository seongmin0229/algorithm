import java.io.*;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] vocas = new String[n];
        int[][] similarities = new int[n][2];

        for(int i = 0; i < n; i++){
            vocas[i] = br.readLine();
            similarities[i][0] = i + 1;
            similarities[i][1] = 0;
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(vocas[i].equals(vocas[j])) continue;

                int similarity = similarity(vocas[i], vocas[j]);
                if(similarity > similarities[i][1]){
//                    System.out.println("i = " + i + "similarity = " + similarity);
                    similarities[i][0] = j;
                    similarities[i][1] = similarity;
                    similarities[j][0] = i;
                    similarities[j][1] = similarity;
                }
            }
        }

        int answerIdx = 0;
        int max = -1;
        for(int i = 0; i < n; i++){
            if(similarities[i][1] > max){
                max = similarities[i][1];
                answerIdx = i;
            }
        }

        bw.append(vocas[answerIdx]).append("\n").append(vocas[similarities[answerIdx][0]]);
//        System.out.println(Arrays.deepToString(similarities));

        bw.flush();
        bw.close();
        br.close();
    }

    private static int similarity(String a, String b) {
        int i = Math.min(a.length(), b.length());
        int count = 0;
        for(int j = 0; j < i; j++){
            if(a.charAt(j) == b.charAt(j)) count++;
            else break;
        }
        return count;
    }
}
