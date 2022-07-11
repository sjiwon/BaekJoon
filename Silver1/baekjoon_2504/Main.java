package Silver1.baekjoon_2504;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        if(!checkBracket(line))
            bw.write(0 + "\n");
        else{
            bw.write(calc(line) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean checkBracket(String line){
        // 일단 괄호열이 옳은 괄호열인지 확인
        Stack<Character> s = new Stack<>();
        for(char ch : line.toCharArray()){
            switch(ch){
                case '(': case'[':
                    s.push(ch);
                    break;
                case ')': case']':
                    if(s.isEmpty())
                        return false;
                    else{
                        if((ch == ')' && s.peek() != '(') || (ch == ']' && s.peek() != '['))
                            return false;
                        s.pop();
                    }
                    break;
            }
        }
        return s.isEmpty();
    }

    static int calc(String line){
        // 옳은 괄호열이면 해당 괄호열 계산
        line = line.replace("()", "2").replace("[]", "3");
        // () -> 2, [] -> 3

        Stack<String> s = new Stack<>();
        for(String ch : line.split("")){
            switch(ch){
                case ")": case "]":
                    int sum = 0;

                    if(ch.equals(")")){
                        // 닫는 괄호 ")" 만나면
                        while(!s.isEmpty() && !s.peek().equals("(")){
                            // ")"의 짝인 "("만날때까지 사이에 존재하는 숫자들 전부 더해주기
                            sum += Integer.parseInt(s.pop());
                        }
                        s.pop(); // 여는 괄호 "(" 없애기 - 계산에 어차피 영향 X
                        s.push(String.valueOf(2*sum)); // "( ~~ )" 계산한 값 (2 곱하기) 스택에 다시 push
                    }
                    else{
                        // 닫는 괄호 "]" 만나면
                        while(!s.isEmpty() && !s.peek().equals("[")){
                            // "]"의 짝인 "["을 만날때까지 사이에 존재하는 숫자들 전부 더해주기
                            sum += Integer.parseInt(s.pop());
                        }
                        s.pop(); // 여는 괄호 "[" 없애기 - 계산에 어차피 영향 X
                        s.push(String.valueOf(3*sum)); //  "[ ~~ ]" 계산한 값 (3 곱하기) 스택에 다시 push
                    }

                    break;
                default:
                    /*
                    여는 괄호( "(" or "[")나 숫자면 그냥 stack에 push
                     */
                    s.push(ch);
                    break;
            }
        }

        int result = 0;
        while(!s.isEmpty())
            // 결국 최종 괄호 계산이 끝나면 스택에는 각 괄호별 계산한 값들만 존재한다
            // 그 값들을 그냥 더해주기만 하면 괄호열 연산이 종료
            result += Integer.parseInt(s.pop());

        return result;
    }
}

