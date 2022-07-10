package Bronze1.baekjoon_2609;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(GCD(a, b) + "\n" + ((a*b)/GCD(a, b)));
        bw.flush();
        bw.close();
        br.close();
    }

    static int GCD(int a, int b){
        if(b==0)
            return a;
        return GCD(b, a%b);
    }
}
