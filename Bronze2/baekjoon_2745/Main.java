package Bronze2.baekjoon_2745;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        bw.write(Long.parseLong(s, B) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
