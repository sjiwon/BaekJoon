package Bronze2.baekjoon_1152;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(st.countTokens() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
