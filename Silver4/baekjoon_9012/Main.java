package Silver4.baekjoon_9012;

import java.io.*;
import java.util.*;
public class Main {
    static Stack<String> s;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean VPS = false;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String text = br.readLine();

            if(VPS(text))
                bw.write("YES\n");
            else
                bw.write("NO\n");
            s.clear();
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static boolean VPS(String text){
        s = new Stack<>();
        String [] check = text.split("");
        for(int i=0; i<check.length; i++){
            if(check[i].equals("("))
                s.push(check[i]);
            else{
                if(s.isEmpty()) return false;
                else if(!(s.peek().equals("(")))
                    return false;
                else
                    s.pop();
            }
        }
        if(!s.isEmpty()) return false;
        else return true;
    }
}
