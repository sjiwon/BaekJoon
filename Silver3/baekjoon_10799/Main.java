package Silver3.baekjoon_10799;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] line = br.readLine().replace("()", "L").split("");

        Stack<String> s = new Stack<>();

        int result = 0; // 잘려진 쇠막대기 조각

        for(String w : line){
            if(w.equals("("))
                s.push(w);
            else{
                if(w.equals("L"))
                    result += s.size();
                else{
                    s.pop();
                    result += 1;
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
