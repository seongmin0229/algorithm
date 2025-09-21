import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringBuilder initialState = new StringBuilder();
        for(int i = 0; i < k; i++){
            initialState.append((char)('A' + i));
        }
        StringBuilder finalState = new StringBuilder(br.readLine());

//        System.out.println("initialState = " + initialState);
//        System.out.println("finalState = " + finalState);

        Deque<String> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            q.addLast(br.readLine());
        }

        while(q.size() != 1){
            if(q.peekFirst().charAt(0) != '?'){
                String s = q.pollFirst();
                for(int i = 0; i < k - 1; i++){
                    if(s.charAt(i) == '-'){
                        char a = initialState.charAt(i);
                        initialState.setCharAt(i, initialState.charAt(i + 1));
                        initialState.setCharAt(i + 1, a);
                    }
                }
            }

            if(q.peekLast().charAt(0) != '?'){
                String s = q.pollLast();
                for(int i = 0; i < k - 1; i++){
                    if(s.charAt(i) == '-'){
                        char a = finalState.charAt(i);
                        finalState.setCharAt(i, finalState.charAt(i + 1));
                        finalState.setCharAt(i + 1, a);
                    }
                }
            }
        }

//        System.out.println(initialState);
//        System.out.println(finalState);
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < k - 1; i++){
            if(initialState.charAt(i) != finalState.charAt(i)){
                if(answer.length() != 0 && answer.charAt(answer.length() - 1) == '-'){
                    System.out.println("x".repeat(k - 1));
                    return;
                }
                answer.append('-');

                char a = initialState.charAt(i);
                initialState.setCharAt(i, initialState.charAt(i + 1));
                initialState.setCharAt(i + 1, a);
            }else{
                answer.append('*');
            }
        }

        System.out.println(answer);
    }
}
