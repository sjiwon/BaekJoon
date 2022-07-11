package Silver4.baekjoon_4949;

import java.io.*;
import java.util.*;
public class Main {
    static Stack<String> s;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String text = br.readLine();
            if(text.equals("."))
                break;
            if (world(text))
                bw.write("yes\n");
            else
                bw.write("no\n");
            s.clear();
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static boolean world(String text){
        s = new Stack<>();
        String [] check = text.split("");
        for(int i=0; i<check.length; i++){
            String ch = check[i];
            switch(ch){
                case "(": case"[":
                    s.push(ch);
                    break;
                case ")": case"]":
                    if (s.isEmpty())
                        return false;
                    else{
                        String pop_ch = s.pop();
                        if((pop_ch.equals("(") && !(ch.equals(")"))) || (pop_ch.equals("[") && !(ch.equals("]"))))
                            return false;
                    }
                    break;
            }
        }

        if(!s.isEmpty()) return false;
        else return true;
    }
}
