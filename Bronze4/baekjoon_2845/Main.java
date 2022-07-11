package Bronze4.baekjoon_2845;

import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            bw.write((Integer.parseInt(st.nextToken()) - (L*P)) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
