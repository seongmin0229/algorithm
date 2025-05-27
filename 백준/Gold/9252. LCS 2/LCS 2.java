import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for(int i = 1; i < a.length() + 1; i++){
            for(int j = 1; j < b.length() + 1; j++){
                if(a.charAt(i - 1) == b.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = getStringBuilder(a, b, dp);

        bw.append(String.valueOf(dp[a.length()][b.length()])).append("\n");
        bw.append(sb.reverse().toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static StringBuilder getStringBuilder(String a, String b, int[][] dp) {
        int startX = a.length();
        int startY = b.length();
        StringBuilder sb = new StringBuilder();
        while(startX >= 1 && startY >= 1){
            if(a.charAt(startX - 1) == b.charAt(startY - 1)){
                sb.append(a.charAt(startX - 1));
                startX--;
                startY--;
            }else{
                if(dp[startX - 1][startY] > dp[startX][startY - 1]){
                    startX--;
                }else{
                    startY--;
                }
            }
        }
        return sb;
    }
}
