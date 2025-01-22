import java.io.*;

public class Main {
    public static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

         String line = "";
         while(!(line = br.readLine()).equals("end")){
             // 1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
             if(!containVowels(line)){
                 notAcceptable(line, bw);
                 continue;
             }
             // 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
             if(contains3ConsecutiveVowelsOrConsonants(line)){
                 notAcceptable(line, bw);
                 continue;
             }
             // 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
             if(contains2ConsecutiveLetters(line)){
                 notAcceptable(line, bw);
                 continue;
             }
             Acceptable(line, bw);
         }
         bw.flush();
         br.close();
         bw.close();
    }

    // a e i o u를 포함하는지 판단하는 함수
    private static boolean containVowels(String line) {
        for(int i = 0; i < line.length(); i++){
            if(isVowel(line.charAt(i))){
                return true;
            }
        }
        return false;
    }

    // 연속된 3개 이상의 모음 또는 자음 판단
    private static boolean contains3ConsecutiveVowelsOrConsonants(String line) {
        int cc = 0;
        int vc = 0;
        boolean curVowelFlag;
        boolean prevVowelFlag = false;

        for(int i = 0; i < line.length(); i++){
            curVowelFlag = isVowel(line.charAt(i));

            if(prevVowelFlag ^ curVowelFlag){
                cc = 0;
                vc = 0;
            }

            if(curVowelFlag){
                vc++;
            }else{
                cc++;
            }

            if(cc >= 3 || vc >= 3){
                return true;
            }

            prevVowelFlag = curVowelFlag;
        }
        return false;
    }

    // 연속된 두글자 판단, e o 제외
    private static boolean contains2ConsecutiveLetters(String line) {
        for(int i = 0; i < line.length(); i++){
            char cur = line.charAt(i);
            if(i < line.length() - 1 && cur == line.charAt(i + 1)){
                if(cur != 'e' && cur != 'o' ){
                    return true;
                }
            }
        }
        return false;
    }

    private static void Acceptable(String line, BufferedWriter bw) throws IOException {
        bw.append("<" + line + "> is acceptable.\n");
    }

    private static void notAcceptable(String line, BufferedWriter bw) throws IOException {
        bw.append("<" + line + "> is not acceptable.\n");
    }

    private static boolean isVowel(char c) {
        for(char vowel : vowels){
            if(c == vowel){
                return true;
            }
        }
        return false;
    }
}