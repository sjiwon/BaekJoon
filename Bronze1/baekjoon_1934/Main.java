package Bronze1.baekjoon_1934;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bw.write((A*B)/GCD(A, B) + "\n");
        }
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
