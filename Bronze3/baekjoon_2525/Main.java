package Bronze3.baekjoon_2525;

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int A;
    static int B;
    static int C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(br.readLine());

        B += C;

        int plus_hour = B / 60;

        A += plus_hour;
        B -= (plus_hour * 60);

        int result_A = A % 24;
        int result_B = B % 60;

        bw.write(result_A + " " + result_B);
        bw.flush();
        bw.close();
        br.close();
    }
}

