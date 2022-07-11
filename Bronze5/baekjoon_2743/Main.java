package Bronze5.baekjoon_2743;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        bw.write(s.length() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
