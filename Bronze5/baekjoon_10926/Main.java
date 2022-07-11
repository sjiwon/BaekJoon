package Bronze5.baekjoon_10926;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder(br.readLine());
        bw.write(sb.append("??!") + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
