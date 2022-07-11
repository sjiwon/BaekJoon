package Bronze3.baekjoon_2914;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int i = Integer.parseInt(st.nextToken());

        bw.write((A*(i-1)+1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
