import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            if(stack.peek() == '('){
                if(s.charAt(i) == ')'){
                    if(s.charAt(i - 1) == '('){
                        stack.pop();
                        answer += stack.size();
                    }else{
                        stack.pop();
                        answer += 1;
                    }
                }else{
                    stack.push(s.charAt(i));
                }
            }

        }

        bw.append(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
