package Bronze3.baekjoon_15894;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write((new BigInteger(br.readLine()).multiply(new BigInteger(String.valueOf(4)))) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
