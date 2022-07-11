package Silver2.baekjoon_1406;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        /*
        원본 = s1에 저장

        (1) L : s1에서 pop해서 s2에 push
        (2) R : s2에서 pop해서 s1에 push
        (3) B : s1에서 pop
        (4) P $ : s1에 $ push
         */

        String [] str = br.readLine().split("");

        for(String c : str)
            s1.push(c);

        int M = Integer.parseInt(br.readLine()); // 명령어 개수

        for(int t=0; t<M; t++){
            String [] cmd = br.readLine().split(" "); // 명령어

            switch(cmd[0]){
                case "L":
                    if(!s1.isEmpty()) { // 커서가 문장 맨 앞이 아닐 경우
                        s2.push(s1.pop());
                    }
                    break;
                case "D":
                    if(!s2.isEmpty()){ // 커서가 문장 맨 뒤가 아닐 경우
                        s1.push(s2.pop());
                    }
                    break;
                case "B":
                    if(!s1.isEmpty()){ // 커서가 문장 맨 앞이 아닐 경우
                        s1.pop();
                    }
                    break;
                case "P":
                    s1.push(cmd[1]);
                    break;
            }
        }

        while(!s1.isEmpty())
            s2.push(s1.pop());

        while(!s2.isEmpty())
            bw.write(s2.pop());

        bw.flush();
        bw.close();
        br.close();
    }
}