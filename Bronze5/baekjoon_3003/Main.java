package Bronze5.baekjoon_3003;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] chess = {1, 1, 2, 2, 2, 8};
        for(int i=0; i<chess.length; i++){
            chess[i] = chess[i] - Integer.parseInt(st.nextToken());
        }

        for(int n : chess)
            bw.write(n + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}
