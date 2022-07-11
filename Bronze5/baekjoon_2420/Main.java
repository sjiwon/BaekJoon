package Bronze5.baekjoon_2420;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());

        bw.write(new BigInteger(String.valueOf(A.subtract(B))).abs() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
