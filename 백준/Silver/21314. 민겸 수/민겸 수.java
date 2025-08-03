import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String mk = br.readLine();

        /**
         * 내 아이디어
         * 최대값의 경우에는 M과 K를 무조건 묶는 방향으로, 단 K가 없을 경우에는 M을 다 따로 처리해줘야 함
         * 최소값의 경우에는 M과 K를 무조건 나누는 방향으로, 단 K가 없을 경우에는 M을 묶어서 처리해줘야 함
         */

        bw.append(maxFromMK(mk)).append("\n");
        bw.append(minFromMK(mk));

        bw.flush();
        bw.close();
        br.close();
    }

    public static String maxFromMK(String mk){
        StringBuilder sb = new StringBuilder();
        int frontMIndex = -1;
        boolean mIsAhead = false;
        for(int i = 0; i < mk.length(); i++){
            if(mk.charAt(i) == 'K'){
                if(mIsAhead){
                    sb.delete(frontMIndex, i);
                    sb.append("5");
                    for(int j = 0; j < i - frontMIndex; j++){
                        sb.append("0");
                    }
                    mIsAhead = false;
                }else{
                    sb.append("5");
                    continue;
                }
            }
            if(mk.charAt(i) == 'M'){
                if(mIsAhead){
                    sb.append("1");
                }else{
                    mIsAhead = true;
                    frontMIndex = i;
                    sb.append("1");
                }
            }
        }

        return sb.toString();
    }

    public static String minFromMK(String mk){
        StringBuilder sb = new StringBuilder();
        boolean mIsAhead = false;
        for(int i = 0; i < mk.length(); i++){
            if(mk.charAt(i) == 'K'){
                if(mIsAhead){
                    mIsAhead = false;
                }
                sb.append("5");
            }
            if(mk.charAt(i) == 'M'){
                if(mIsAhead){
                    sb.append("0");
                }else {
                    sb.append("1");
                    mIsAhead = true;
                }
            }
        }
        return sb.toString();
    }
}
