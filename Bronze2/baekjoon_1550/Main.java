package Bronze2.baekjoon_1550;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        bw.write(Integer.parseInt(s, 16) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
