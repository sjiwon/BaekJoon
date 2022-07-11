package Gold2.baekjoon_1918;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        bw.write(postfix(line) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static String postfix(String line){
        // 중위 표기 -> 후위 표기
        // stack에는 무조건 peek()의 우선순위보다 높은 우선순위만 허용
        // 만약 낮은 우선순위가 들어오려고한다? 스택에 해당 값보다 우선순위 높은것들은 전부 pop

        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();

        for(char ch : line.toCharArray()){
            switch(ch){
                case '+': case '-': case '*': case '/':
                    while(!s.isEmpty() && (priority(ch) <= priority(s.peek())))
                        sb.append(s.pop());
                    s.push(ch);
                    break;
                case '(':
                    s.push(ch);
                    break;
                case ')':
                    while(s.peek() != '(')
                        sb.append(s.pop());
                    s.pop();
                    break;
                default:
                    // 피연산자는 그냥 출력
                    sb.append(ch);
            }
        }
        while(!s.isEmpty())
            sb.append(s.pop());

        return sb.toString();
    }

    static int priority(char op){
        switch(op){
            case '(': case ')':
                return 1;
            case '+': case'-':
                return 2;
            case '*': case'/':
                return 3;
        }
        return -1;
    }
}
