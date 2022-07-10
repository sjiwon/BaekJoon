package Bronze2.baekjoon_2902;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        String [] word = s.split("-");

        for(String w : word)
            sb.append(w.charAt(0));

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
